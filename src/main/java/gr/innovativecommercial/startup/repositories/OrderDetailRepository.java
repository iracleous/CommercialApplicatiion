package gr.innovativecommercial.startup.repositories;


import gr.innovativecommercial.startup.models.Orderdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<Orderdetail, Integer> {
}
