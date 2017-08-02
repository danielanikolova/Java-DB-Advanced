package student.system.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.system.entities.Student;
import student.system.repositories.StudentRepository;
import student.system.services.StudentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService<Student, Long>{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findOne(id);
    }

    @Override
    public void remove(Student student) {

        this.studentRepository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student student) {

        this.studentRepository.save(student);
    }

    @Override
    public List<Object[]> getStudentsAndHomeworkSubmissions() {
        return this.studentRepository.getStudentsAndHomeworkSubmissions();
    }

    @Override
    public List<Object[]> getAllStudentsAndCoursesEnrolledInAndTotalPrice() {
        return this.studentRepository.getAllStudentsAndCoursesEnrolledInAndTotalPrice();
    }
}
