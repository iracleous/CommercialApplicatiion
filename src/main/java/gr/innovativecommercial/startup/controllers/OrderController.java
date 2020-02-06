package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.dtos.OrderDto;
import gr.innovativecommercial.startup.models.Customerorder;
import gr.innovativecommercial.startup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("order/{id}")
    public Customerorder getOrder(@PathVariable int id){
         return orderService.findById(id);
    }

   @PostMapping("order")
   public Customerorder createOrder(@RequestBody OrderDto orderDto) throws Exception {
      return orderService.createOrder(orderDto);
   }

    @GetMapping("order/doscenario")
    public String doScenario( ){
        return orderService.doScenario();
    }


}
