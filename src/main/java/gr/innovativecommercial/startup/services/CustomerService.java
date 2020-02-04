package gr.innovativecommercial.startup.services;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.repositories.Customers;
import gr.innovativecommercial.startup.repositories.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    private Customers customerRepo;

    public Customer getCustomer(int id){
        return customerRepo.findById(id).get();
    }


    public Customer save(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setDob( new Date(customerDto.getYearBirth(),
                customerDto.getMonthBirth() , 1));

        return customerRepo.save(customer);
    }


    public List<CustomerOrder> getCustomerOrders(int id){
        return customerRepo.findById(id).get().getOrders();
    }
}
