package student.system.services;


import java.util.Date;
import java.util.List;

public interface CourseService<Course, Long> {


    Course findById(Long id);

    void remove(Course course);

    List<Course> findAll();

    void save(Course course);


   List<Object[]> findAllCoursesAndResources();

    List<Object[]> findAllCoursesWithMoreThan5Resources();

    List<Object[]> findAllCoursesActiveOnDate(Date date);
}
