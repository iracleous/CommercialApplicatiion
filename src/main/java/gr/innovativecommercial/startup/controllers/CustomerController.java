package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("customerid")
    public Customer getCustomerById(@RequestParam int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customer")
    public Customer newCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.save(customerDto);
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

