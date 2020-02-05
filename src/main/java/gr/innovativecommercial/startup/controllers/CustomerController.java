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
    public Customer getCustomer(@PathVariable int id) throws CustomerNotFoundException {

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
    @GetMapping("customer/count")
    public int getCustomerCount( ) {
        return customerService.getCount();
    }
    @GetMapping("customerid")
    public Customer getCustomerById(@RequestParam int id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }




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

