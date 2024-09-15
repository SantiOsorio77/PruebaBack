package PruebaEcommerceBack.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor  // Constructor sin argumentos requerido por Hibernate
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    @ManyToOne
    private ProductEntity producto;

    private Integer cantidad;
    private Double total;

    @Builder
    public OrderEntity(LocalDateTime fecha, ProductEntity producto, Integer cantidad, Double total) {
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }
}
