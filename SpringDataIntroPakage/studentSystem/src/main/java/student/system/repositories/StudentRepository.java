package student.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import student.system.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{


    @Query("select s.name, h.content, h.contentType from Student as s " +
            "join s.homeworkSet as h")
    List<Object[]> getStudentsAndHomeworkSubmissions();


    @Query("select s.name, s.courses.size, Sum(c.price), avg(c.price) as totalPrice from Student as s "+
            "join s.courses as c "+
            "group by s.name " +
            "order by Sum(c.price) desc, s.courses.size desc, s.name asc ")
    List<Object[]> getAllStudentsAndCoursesEnrolledInAndTotalPrice();



}
