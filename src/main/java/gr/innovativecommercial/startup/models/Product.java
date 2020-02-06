package gr.innovativecommercial.startup.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private double productPrice;
    private int productQuantity;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Orderdetail> orderdetails;
}

