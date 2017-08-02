package student.system.services;


import java.util.List;

public interface StudentService<Student, Long> {


    Student findById(Long id);

    void remove(Student student);

    List<Student> findAll();

    void save(Student student);

    List<Object[]> getStudentsAndHomeworkSubmissions();

    List<Object[]> getAllStudentsAndCoursesEnrolledInAndTotalPrice();


}
