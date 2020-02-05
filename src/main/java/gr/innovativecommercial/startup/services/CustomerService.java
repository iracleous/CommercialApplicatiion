package gr.innovativecommercial.startup.services;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.exceptions.CustomerNotFoundException;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.repositories.Customers;
import gr.innovativecommercial.startup.repositories.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {
    @Autowired
    private Customers customerRepo;


    public Customer updateOne(int id, CustomerDto customerDto) throws CustomerNotFoundException {
       Customer customer= customerRepo.findById(id).get();
       if (customer == null) {
           throw new CustomerNotFoundException("Customer id = " + id);
       }
       customer.setAddress(customerDto.getAddress());
    if (customerDto.getName()!=null)    customer.setCustomerName(customerDto.getName());

        return customerRepo.save(customer);
    }


    public List<Customer> getAll(){
        return
                StreamSupport
                        .stream(customerRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());



    }

    public Customer getCustomer(int id) throws CustomerNotFoundException {

        try {
            Customer  customer = customerRepo.findById(id).get();
            return customer;
       }catch (Exception e) {
            throw new CustomerNotFoundException("Customer id = " + id);
        }

    }


    public Customer save(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setDob( new Date(customerDto.getYearBirth(),
                customerDto.getMonthBirth() , 1));

        return customerRepo.save(customer);
    }

    public int getCount(){
        List<String> cs=customerRepo.findByCustomerName("dimitris");
      //  customerRepo. addPrefixToFirstName("Dr ");
        return cs.size();
     //   return  customerRepo.countCustomers();
    }
// 1;}   //
    public List<CustomerOrder> getCustomerOrders(int id){
        return  customerRepo.findById(id).get().getOrders();
    }
}
