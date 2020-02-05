package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.repositories.Orders;
import gr.innovativecommercial.startup.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private Orders orderRepo;

    @GetMapping("order/{id}")
    public CustomerOrder getOrder(@PathVariable int id){
         return orderRepo.findById(id).get();
    }



}
