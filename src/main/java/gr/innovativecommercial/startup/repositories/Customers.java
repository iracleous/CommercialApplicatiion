package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface Customers extends PagingAndSortingRepository<Customer, Integer> {

//
//
//     @Query(value ="select count(id) FROM customer ", nativeQuery = true)
//     Integer   countCustomers();
//
//    @Query(value = "SELECT *  FROM customer", nativeQuery = true)
//    List<Object[]> getAll();
//
//
//
//    @Query(value = "SELECT [customer_name]  FROM customer WHERE customer_name = :firstName", nativeQuery = true)
//    List<String> findByCustomerName(@Param("firstName") String firstName);
//
//    @Query(value = "UPDATE Customer SET customer_Name = :prefix + customer_Name", nativeQuery = true)
//    @Modifying
//    @Transactional
//    void addPrefixToFirstName(@Param("prefix") String prefix);

}