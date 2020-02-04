package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Orders extends CrudRepository<CustomerOrder, Integer> {
}