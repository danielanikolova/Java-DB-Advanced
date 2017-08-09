package car.dealer.repositories;

import car.dealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    //Query 1 – Ordered Customers

    @Query(value = "select * from customers as c\n" +
            "order by c.birthday asc, c.is_young_driver asc", nativeQuery = true)
    List<Customer> getAllOrderedByExperience();


    @Query(value = "select c.name, count(cars.id) as total_cars, sum(cars.price) as spent_money \n" +
            "from customers as c\n" +
            "inner join sales s on s.customer_id = c.id\n" +
            "inner join cars on cars.id = s.car_id\n" +
            "group by c.name\n" +
            "order by spent_money desc, total_cars desc", nativeQuery = true)
    List<Object[]>findCustomersBoughtCars();
}
