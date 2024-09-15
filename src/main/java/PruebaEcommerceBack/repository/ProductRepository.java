package PruebaEcommerceBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PruebaEcommerceBack.dto.ProductDto;
import PruebaEcommerceBack.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductDto save(ProductDto producto);
}
