package PruebaEcommerceBack.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class OrderDto {
    private Long id;
    private LocalDateTime fecha;
    private ProductDto producto;
    private Integer cantidad;
    private Double total;
}
