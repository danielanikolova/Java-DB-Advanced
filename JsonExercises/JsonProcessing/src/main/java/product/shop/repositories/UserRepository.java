package product.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product.shop.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    @Query("select distinct u from User as u " +
            "inner join u.soldProducts as p " +
            "where p.buyer is not null " +
            "order by u.lastName, u.firstName")
    List<User>findAllBySoldProducts();

    @Query(value = "select * from users as u\n" +
            "inner join products as p on u.id=p.seller_id\n" +
            "group by p.seller_id\n" +
            "having p.buyer_id is not null", nativeQuery = true)
    List<User> findUsersWithProductsCount();

//    @Query(value = "SELECT c.name, count(p.name) AS product_count, avg(p.price), sum(p.price)\n" +
//            "FROM categories AS c \n" +
//            "INNER JOIN product_categoy AS pc\n" +
//            "ON c.id = pc.category_id\n" +
//            "INNER JOIN products AS p \n" +
//            "ON pc.product_id = p.id\n" +
//            "GROUP BY c.name\n" +
//            "ORDER BY product_count", nativeQuery = true)
//    List<Object[]>CategoriesByProductsCount();

}
