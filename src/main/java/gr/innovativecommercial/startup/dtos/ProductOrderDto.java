package gr.innovativecommercial.startup.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDto {
    private int productId;
    private int purchasedQuantity;
}
