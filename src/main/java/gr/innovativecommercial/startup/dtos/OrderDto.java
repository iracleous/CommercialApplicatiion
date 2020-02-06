package gr.innovativecommercial.startup.dtos;

import gr.innovativecommercial.startup.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private int customerId;
    private List<ProductOrderDto>  products;

}
