package PruebaEcommerceBack.repository;

import PruebaEcommerceBack.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByFecha(LocalDateTime fecha);
    List<OrderEntity> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    List<OrderEntity> findByProductoId(Long productoId);
    List<OrderEntity> findByCantidadGreaterThan(Integer cantidadMinima);
    @Query("SELECT SUM(p.total) FROM OrderEntity p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin")
    Double obtenerTotalVentasEnRangoDeFechas(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}
