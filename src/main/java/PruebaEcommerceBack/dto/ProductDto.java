package PruebaEcommerceBack.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
}
