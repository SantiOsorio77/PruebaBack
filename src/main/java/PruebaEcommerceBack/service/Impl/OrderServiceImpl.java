package PruebaEcommerceBack.service.Impl;

import PruebaEcommerceBack.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.List;


public interface OrderServiceImpl {

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long id);

    OrderDto saveOrder(OrderDto orderDto);

    void deleteOrder(Long id);

    List<OrderDto> gerOrderByDate(LocalDateTime fecha);

    List<OrderDto> getOrdersByRangeDate(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<OrderDto> getOrdersByProduct(Long productoId);

    List<OrderDto> getOrdesQuantityGreater(Integer cantidadMinima);
    Double getTotalSalesDateRange(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
