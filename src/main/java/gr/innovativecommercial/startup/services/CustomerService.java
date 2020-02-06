package gr.innovativecommercial.startup.services;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.exceptions.CustomerNotFoundException;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.Customerorder;
import gr.innovativecommercial.startup.repositories.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {
    @Autowired
    private Customers customerRepo;


    public List<Customer> getCustomersByAgeRange(int ageFrom, int ageTo)
            throws CustomerNotFoundException {
        //20,40
        int thisYear= new Date().getYear();
        int yearTo= thisYear -ageFrom ; //2000
        int yearFrom  = thisYear - ageTo; //1980

        try {
            return
                StreamSupport
                   .stream(customerRepo.findAll().spliterator(), false)
                   .filter(customer->
                           customer.getDob().getYear()>=yearFrom)
                   .filter(customer->
                                customer.getDob().getYear()<=yearTo)
                   .collect(Collectors.toList());
        }
        catch(Exception e){
            throw new CustomerNotFoundException("no customers found");
        }
    }

    public String softDelete(int id ) throws CustomerNotFoundException {
       try {
           Customer customer = customerRepo.findById(id).get();
           customer.setActive(false);
           customerRepo.save(customer);
           return "ok";
       }
       catch(Exception e){
           throw new CustomerNotFoundException("Customer id = " + id);
       }


    }

    public List<Customer> getBestCustomers(int howMany) {
        return   StreamSupport
                .stream(customerRepo.findAll().spliterator(), false)
          //      .sorted()
                .limit(howMany)
                .collect(Collectors.toList());


    }



 public List<Customer> getCustomersByPage(int size, int page){
     Pageable selectedPageOf20Elements = PageRequest.of(page, size);

    return customerRepo.findAll(selectedPageOf20Elements).toList();

 }


    public List<Customer> readByName(String name){
        return
                StreamSupport
                       .stream(customerRepo.findAll().spliterator(), false)
                       .filter(customer -> customer.getCustomerName().equals(name))
                       .collect(Collectors.toList());
     }



    public String delete(int id)throws CustomerNotFoundException {
       customerRepo.deleteById(id);
       return "deleted";
    }
    public String delete()throws CustomerNotFoundException {
        customerRepo.deleteAll();
        return "deleted";
    }


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





//    public int getCount(){
//        List<String> cs=customerRepo.findByCustomerName("dimitris");
//      //  customerRepo. addPrefixToFirstName("Dr ");
//        return cs.size();
//     //   return  customerRepo.countCustomers();
//    }
//// 1;}   //
    public List<Customerorder> getCustomerOrders(int id){
        return  customerRepo.findById(id).get().getCustomerOrder();
    }
}
