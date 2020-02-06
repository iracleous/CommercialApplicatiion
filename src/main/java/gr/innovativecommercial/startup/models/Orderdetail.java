package gr.innovativecommercial.startup.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Orderdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
 //   @JoinColumn
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Product product;

    @ManyToOne
 //   @JoinColumn
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customerorder customerorder;


    private int buyingQuantity;


    public Orderdetail(Customerorder customerOrder, Product product, int buyingQuantity) {
        this.product = product;
        this.customerorder = customerOrder;
        this.buyingQuantity = buyingQuantity;
    }
}
