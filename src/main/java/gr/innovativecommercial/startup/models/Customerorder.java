package gr.innovativecommercial.startup.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Customerorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;

    @ManyToOne
 //   @JoinColumn
 //   @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;


    @OneToMany(mappedBy = "customerorder")
    @JsonIgnore
    private List<Orderdetail> orderdetails;

}
