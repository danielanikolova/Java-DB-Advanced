package car.dealer.repositories;

import car.dealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{


    @Query(value = "select * from suppliers as s\n" +
            "where s.is_importer=1", nativeQuery = true)
    List<Supplier> findAllLocalSuppliers();

}
