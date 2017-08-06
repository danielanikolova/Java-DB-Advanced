package car.dealer.repositories;

import car.dealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

    @Query(value = "select car.id, c.name, s.discount, car.price from sales as s \n" +
            "inner join customers as c on s.customer_id = c.id\n" +
            "inner join cars as car on s.car_id = car.id", nativeQuery = true)
    List<Object[]> findSalesWithDiscounts();
}
