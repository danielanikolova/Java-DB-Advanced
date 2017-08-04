package product.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.shop.entities.Product;
import product.shop.entities.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product>getProductsByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal minPrice, BigDecimal maxPrice);

}
