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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private String address;
    private Date dob;
    @Column(columnDefinition = "bit default 1")
    private boolean active;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Customerorder> customerOrder;





}
