package PruebaEcommerceBack.mapper;

import PruebaEcommerceBack.dto.ProductDto;
import PruebaEcommerceBack.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductEntity productDtoToProductEntity (ProductDto productDto) {
        return ProductEntity
                .builder()
                .nombre(productDto.getNombre())
                .descripcion(productDto.getDescripcion())
                .precio(productDto.getPrecio())
                .cantidad(productDto.getCantidad())
                .build();
    }

    public static ProductDto productEntityToProductDto (ProductEntity productEntity) {
        return ProductDto
                .builder()
                .id(productEntity.getId())
                .nombre(productEntity.getNombre())
                .descripcion(productEntity.getDescripcion())
                .precio(productEntity.getPrecio())
                .cantidad(productEntity.getCantidad())
                .build();
    }

    public static List<ProductDto> productEntitiesToProductDtos(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(ProductMapper::productEntityToProductDto)
                .collect(Collectors.toList());
    }

}
