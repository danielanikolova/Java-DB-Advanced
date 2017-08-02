package student.system.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.system.entities.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long>{
}
