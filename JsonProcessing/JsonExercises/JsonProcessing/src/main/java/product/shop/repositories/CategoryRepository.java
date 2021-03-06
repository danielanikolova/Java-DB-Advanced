package product.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product.shop.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{


    @Query(value = "SELECT c.name, count(p.name) AS product_count, avg(p.price), sum(p.price)\n" +
            "FROM categories AS c \n" +
            "INNER JOIN product_categoy AS pc\n" +
            "ON c.id = pc.category_id\n" +
            "INNER JOIN products AS p \n" +
            "ON pc.product_id = p.id\n" +
            "GROUP BY c.name\n" +
            "ORDER BY product_count", nativeQuery = true)
    List<Object[]>CategoriesByProductsCount();





}
