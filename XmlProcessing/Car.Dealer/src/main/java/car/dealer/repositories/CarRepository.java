package car.dealer.repositories;

import car.dealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

   // Query 2 – Cars from make Toyota

    @Query(value = "select * from cars as c\n" +
            "where c.make = \"Toyota\" \n" +
            "order by c.model, c.traveled_distance desc", nativeQuery = true)
    List<Car> findFyMakeToyota();

}
