package student.system.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import student.system.entities.Course;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{



    @Query("SELECT c.name, c.description from Course as c ")
    List<Object[]> findAllCoursesAndResources();

    @Query("select s.name, count(r.name) as resourceCount from Course as s " +
            "join s.resources as r " +
            "group by s.name " +
            "having count(r.name)>=5 " +
            "order by resourceCount desc, s.startDate desc")
    List<Object[]> findAllCoursesWithMoreThan5Resources();

    @Query("select c.name,Date(c.startDate), Date(c.endDate),datediff(c.endDate, c.startDate)," +
            "count(s.id) as studentEnrolled from Course as c " +
            "join c.students as s " +
            "where Date(c.startDate) = :date "+
            "group by c.name ")
    List<Object[]> findAllCoursesActiveOnDate(@Param("date") Date date);


}
