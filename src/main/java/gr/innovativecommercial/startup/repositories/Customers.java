package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Customers extends JpaRepository<Customer, Integer> {
}