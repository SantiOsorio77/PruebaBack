package PruebaEcommerceBack.service;

import PruebaEcommerceBack.dto.ProductDto;
import PruebaEcommerceBack.entity.ProductEntity;
import PruebaEcommerceBack.repository.ProductRepository;
import PruebaEcommerceBack.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static PruebaEcommerceBack.mapper.ProductMapper.*;

@Service
public class ProductService implements ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntitiesToProductDtos(productEntities);
    }

    public ProductDto getProductById(Long id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        assert product != null;
        return productEntityToProductDto(product);
    }

    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity product = productDtoToProductEntity(productDto);
        ProductEntity productEntitySave = productRepository.save(product);
        return productEntityToProductDto(productEntitySave);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        ProductEntity productEntityExistente = productRepository.findById(id).orElse(null);

        if (productEntityExistente != null) {

            productEntityExistente.setNombre(productDto.getNombre());
            productEntityExistente.setDescripcion(productDto.getDescripcion());
            productEntityExistente.setPrecio(productDto.getPrecio());
            productEntityExistente.setCantidad(productDto.getCantidad());
            ProductEntity productEntity = productRepository.save(productEntityExistente);
            return productEntityToProductDto(productEntity);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
