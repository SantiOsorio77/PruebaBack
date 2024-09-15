package PruebaEcommerceBack.service.Impl;

import PruebaEcommerceBack.dto.ProductDto;

import java.util.List;

public interface ProductServiceImpl {
     List<ProductDto> getAllProduct();
     ProductDto getProductById(Long id);
     ProductDto saveProduct(ProductDto productDto);
     ProductDto updateProduct(Long id, ProductDto productDto);
     void deleteProduct(Long id);

}
