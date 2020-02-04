package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.repositories.Products;
import gr.innovativecommercial.startup.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

}
