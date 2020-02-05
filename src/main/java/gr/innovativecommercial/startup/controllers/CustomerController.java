package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.exceptions.CustomerNotFoundException;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/**
 *
 */
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * Task 1.1
     * Reads one customer by id
     * @param id customer id
     * @return the customer
     * @throws CustomerNotFoundException
     */

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable int id)
            throws CustomerNotFoundException {

        return customerService.getCustomer(id);
    }

    /**
     * 1.2
     * @param customerDto
     * @return
     */

    @PostMapping("customer")
    public Customer newCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    /**
     * 1.3 returns all customers
     * @return
     */
    @GetMapping("customers")
    public List<Customer> readAll( ) {
        return customerService.getAll();
    }

    /**
     * 1.4
     * @param id
     * @param customerDto
     * @return
     */
    @PutMapping("customer/{id}")
    public Customer updateOne(@PathVariable int id,
                              @RequestBody CustomerDto customerDto)
            throws CustomerNotFoundException {
        return customerService.updateOne(id, customerDto);
    }

    //1.5
    @DeleteMapping("customer/{id}" )
    public String deleteCustomer(@PathVariable int id)
            throws CustomerNotFoundException {
        return customerService.delete(id);
    }

    //1.6
    @DeleteMapping("customer " )
    public String deleteAllCustomer( )
            throws CustomerNotFoundException {
        return customerService.delete();
    }

//1.7
    @GetMapping("customers/name/{name}")
    public List<Customer> getCustomersByName( @PathVariable String name)
            throws CustomerNotFoundException {
        return customerService.readByName(name);
    }

//1.8

@PutMapping("customer/inactive/{id}")
  public String softDelete( @PathVariable int id) throws CustomerNotFoundException {
    return customerService.softDelete(id);
}


//1.9
  @GetMapping("customers/ageFrom/{ageFrom}/ageTo/{ageTo}")
  public List<Customer> getCustomersByAgeRange( @PathVariable int ageFrom, @PathVariable int ageTo)
          throws CustomerNotFoundException {
      return customerService.getCustomersByAgeRange(ageFrom, ageTo);
  }

  //1.10
  @GetMapping("customers/pageSize/{size}/page/{page}")
  public List<Customer> getCustomersPaged( @PathVariable int size,@PathVariable int page )
          throws CustomerNotFoundException {
      return customerService.getCustomersByPage(size, page);
  }

  //1.11
  @GetMapping("customers/best/{howMany}")
  public List<Customer> getBestCustomers( @PathVariable int howMany )
          throws CustomerNotFoundException {
      return customerService.getBestCustomers(howMany);
  }

//    @GetMapping("customer/count")
//    public int getCustomerCount( ) {
//        return customerService.getCount();
//    }
//    @GetMapping("customerid")
//    public Customer getCustomerById(@RequestParam int id) throws CustomerNotFoundException {
//        return customerService.getCustomer(id);
//    }




    @GetMapping("customer/{id}/orders")
    public List<CustomerOrder> getCustomerOrders(@PathVariable int id) {
        return customerService.getCustomerOrders(id);
    }


    @RequestMapping(path = "newCustomer", method = RequestMethod.POST)
    @CrossOrigin
    public Customer editAdvert(
            @RequestParam String name,
            @RequestParam String address
    ) {
        CustomerDto customer = new CustomerDto();
        customer.setName(name);
        customer.setAddress(address);
        return customerService.save(customer);
    }

}

