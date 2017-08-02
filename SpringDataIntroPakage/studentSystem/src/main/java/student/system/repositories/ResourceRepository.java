package student.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.system.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{
}
