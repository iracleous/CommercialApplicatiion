package gr.innovativecommercial.startup.repositories;


import gr.innovativecommercial.startup.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products extends CrudRepository<Product, Integer> {
}

