package student.system.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.system.entities.Course;
import student.system.repositories.CourseRepository;
import student.system.services.CourseService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService<Course, Long> {


    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public Course findById(Long id) {
        return this.courseRepository.findOne(id);
    }

    @Override
    public void remove(Course course) {

    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public void save(Course course) {

        this.courseRepository.save(course);
    }

    @Override
    public List<Object[]> findAllCoursesAndResources() {
        return this.courseRepository.findAllCoursesAndResources();
    }

    @Override
    public List<Object[]> findAllCoursesWithMoreThan5Resources() {
        return this.courseRepository.findAllCoursesWithMoreThan5Resources();
    }

    @Override
    public List<Object[]> findAllCoursesActiveOnDate(Date date) {
        return this.courseRepository.findAllCoursesActiveOnDate(date);
    }
}
