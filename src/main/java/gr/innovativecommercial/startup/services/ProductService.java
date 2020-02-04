package gr.innovativecommercial.startup.services;

import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.repositories.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private Products productRepo;

    public Product getProduct(int id){
        return productRepo.findById(id).get();
    }
}
