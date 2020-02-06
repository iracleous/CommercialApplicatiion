package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.Customerorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Orders extends JpaRepository<Customerorder, Integer> {
}