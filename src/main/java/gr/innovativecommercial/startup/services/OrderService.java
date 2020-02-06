package gr.innovativecommercial.startup.services;


import gr.innovativecommercial.startup.dtos.OrderDto;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.Customerorder;
import gr.innovativecommercial.startup.models.Orderdetail;
import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.repositories.Customers;
import gr.innovativecommercial.startup.repositories.OrderDetailRepository;
import gr.innovativecommercial.startup.repositories.Orders;
import gr.innovativecommercial.startup.repositories.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private Customers customerRepo;
    @Autowired
    private Orders orderRepo;
    @Autowired
    private Products productRepo;
    @Autowired
    private OrderDetailRepository productOrderRepo;
/*
{"customerId":1,
     "products":[
	{ "productId":1,"purchasedQuantity":3},
	{ "productId":2,"purchasedQuantity":1}
	]}
 */

    public Customerorder createOrder(OrderDto orderDto) throws Exception {

        if (orderDto==null) throw new Exception("order dto is null");
        Customer c1 = customerRepo.findById(orderDto.getCustomerId()).get();
        if (c1==null)throw new Exception("customer is not found");
          if (orderDto.getProducts()==null)
            throw new Exception("given product list is null");

        Customerorder o1 = new Customerorder();

        o1.setCustomer(c1);
        o1.setOrderdetails(new ArrayList<>());
       orderRepo.save(o1);
         orderDto.getProducts().forEach(
             productOrderDto ->{

                 Orderdetail od =  new Orderdetail(o1,
                         productRepo.findById(productOrderDto.getProductId()).get(),
                         productOrderDto.getPurchasedQuantity());

                 productOrderRepo.save(od);
                     o1.getOrderdetails().add(od );

             });


    //    orderRepo.save(o1);

        return o1;
    }



    public Customerorder findById(int id){
       return orderRepo.findById(id).get();
    }


    public String doScenario(){

       Customer c1 = customerRepo.findById(1).get();
        Product p1 = productRepo.findById(2).get();
       Customerorder o1 = new Customerorder();

        o1.setCustomer(c1);
       o1.setOrderdetails(new ArrayList<>());
        orderRepo.save(o1);

        Orderdetail od = new Orderdetail(o1, p1,1);

        productOrderRepo.save(od);
       o1.getOrderdetails().add(od);


       orderRepo.save(o1);

        return "ok";
    }

}