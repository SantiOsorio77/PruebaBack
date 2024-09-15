package PruebaEcommerceBack.service;

import PruebaEcommerceBack.dto.OrderDto;
import PruebaEcommerceBack.entity.OrderEntity;
import PruebaEcommerceBack.entity.ProductEntity;
import PruebaEcommerceBack.repository.OrderRepository;
import PruebaEcommerceBack.repository.ProductRepository;
import PruebaEcommerceBack.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static PruebaEcommerceBack.mapper.OrderMapper.*;
import static PruebaEcommerceBack.mapper.ProductMapper.productDtoToProductEntity;

@Service
public class OrderService implements OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderEntitiesToOrderDtos(orderEntities);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElse(null);
        if (orderEntity == null) {
            throw new IllegalArgumentException("No se encontró el pedido con ID: " + id);
        }
        return orderEntityToOrderDto(orderEntity);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        ProductEntity productEntity = productDtoToProductEntity(orderDto.getProducto());
        if (productEntity.getId() == null || !productRepository.existsById(productEntity.getId())) {
            productEntity = productRepository.save(productEntity);
        }

        OrderEntity orderEntity = orderDtoToOrderEntity(orderDto);
        orderEntity.setProducto(productEntity); 

       
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return orderEntityToOrderDto(savedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar, el pedido con ID: " + id + " no existe.");
        }
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> gerOrderByDate(LocalDateTime fecha) {
        List<OrderEntity> orderEntities = orderRepository.findByFecha(fecha);
        return orderEntitiesToOrderDtos(orderEntities);
    }

    @Override
    public List<OrderDto> getOrdersByRangeDate(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<OrderEntity> orderEntities = orderRepository.findByFechaBetween(fechaInicio, fechaFin);
        return orderEntitiesToOrderDtos(orderEntities);
    }

    @Override
    public List<OrderDto> getOrdersByProduct(Long productoId) {
        List<OrderEntity> orderEntities = orderRepository.findByProductoId(productoId);
        return orderEntitiesToOrderDtos(orderEntities);
    }

    @Override
    public List<OrderDto> getOrdesQuantityGreater(Integer cantidadMinima) {
        List<OrderEntity> orderEntities = orderRepository.findByCantidadGreaterThan(cantidadMinima);
        return orderEntitiesToOrderDtos(orderEntities);
    }

    @Override
    public Double getTotalSalesDateRange(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return orderRepository.obtenerTotalVentasEnRangoDeFechas(fechaInicio, fechaFin);
    }
}
