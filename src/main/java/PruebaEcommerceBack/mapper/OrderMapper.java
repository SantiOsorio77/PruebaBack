package PruebaEcommerceBack.mapper;

import PruebaEcommerceBack.dto.OrderDto;
import PruebaEcommerceBack.dto.ProductDto;
import PruebaEcommerceBack.entity.OrderEntity;
import PruebaEcommerceBack.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

import static PruebaEcommerceBack.mapper.ProductMapper.productDtoToProductEntity;
import static PruebaEcommerceBack.mapper.ProductMapper.productEntityToProductDto;

public class OrderMapper {

    public static OrderEntity orderDtoToOrderEntity(OrderDto orderDto) {

        ProductEntity productEntity = productDtoToProductEntity(orderDto.getProducto());

        return OrderEntity
                .builder()
                .fecha(orderDto.getFecha())
                .cantidad(orderDto.getCantidad())
                .total(orderDto.getTotal())
                .producto(productEntity)
                .build();
    }

    public static OrderDto orderEntityToOrderDto(OrderEntity orderEntity) {
        ProductDto productDto = productEntityToProductDto(orderEntity.getProducto());

        return OrderDto.builder()
                .id(orderEntity.getId())
                .fecha(orderEntity.getFecha())
                .cantidad(orderEntity.getCantidad())
                .total(orderEntity.getTotal())
                .producto(productDto)
                .build();
    }

    public static List<OrderDto> orderEntitiesToOrderDtos(List<OrderEntity> orderEntities) {
        return orderEntities.stream()
                .map(OrderMapper::orderEntityToOrderDto)
                .collect(Collectors.toList());
    }
}
