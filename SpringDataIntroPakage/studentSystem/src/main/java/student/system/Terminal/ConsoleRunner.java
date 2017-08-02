package student.system.Terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student.system.entities.Course;
import student.system.entities.Homework;
import student.system.entities.Resource;
import student.system.entities.Student;
import student.system.entities.enums.enums.ContentType;
import student.system.entities.enums.enums.ResourceType;
import student.system.services.CourseService;
import student.system.services.HomeworkService;
import student.system.services.ResourceService;
import student.system.services.StudentService;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner{

    private final CourseService<Course, Long> courseService;

    private final HomeworkService<Homework, Long> homeworkService;

    private final StudentService<Student, Long> studentService;

    private final ResourceService<Resource, Long> resourceService;

    @Autowired
    public ConsoleRunner(CourseService<Course, Long> courseService, HomeworkService<Homework, Long> homeworkService, StudentService<Student, Long> studentService, ResourceService<Resource, Long> resourceService) {
        this.courseService = courseService;
        this.homeworkService = homeworkService;
        this.studentService = studentService;
        this.resourceService = resourceService;
    }


    @Override
    public void run(String... strings) throws Exception {

//        seedDatabase();

        //7.2
//        List<Object[]> coursesAndResources = this.courseService.findAllCoursesAndResources();
//        for (Object[] coursesAndResource : coursesAndResources) {
//            System.out.printf("%s %s\n",coursesAndResource[0], coursesAndResource[1]);
//        }
//
//        coursesAndResources.forEach(c -> System.out.println(String.join(", ",
//                Arrays.stream(c)
//                        .filter(o -> o != null)
//                        .map(Object::toString).collect(Collectors.toList()))));

        //7.1
//        List<Object[]> studentsAndHomeworks = this.studentService.getStudentsAndHomeworkSubmissions();
//        for (Object[] studentsAndHomework: studentsAndHomeworks) {
//            System.out.printf("Name:%s, Content:%s, Content Type:%s\n",
//                    studentsAndHomework[0],
//                    studentsAndHomework[1],
//                    studentsAndHomework[2]);
//        }

        //7.3
//        List<Object[]> allCoursesWithMoreThan5Resources = this.courseService.findAllCoursesWithMoreThan5Resources();
//
//        if (allCoursesWithMoreThan5Resources.size()>=1){
//            for (Object[] courseWithHomework:allCoursesWithMoreThan5Resources) {
//                System.out.printf("Course name: %s, resource count: %s\n",
//                        courseWithHomework[0],
//                        courseWithHomework[1]);
//            }
//        }
//        else {
//            System.out.println("There is no such course");
//        }

        //7.4

//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = df.parse("10/10/2014");
//
//
//        List<Object[]> allCoursesActiveOnDate = this.courseService.findAllCoursesActiveOnDate(date);
//
//        for (Object[] courseActiveOnDate :allCoursesActiveOnDate) {
//
//            System.out.printf("Course name: %s, startDate %s, endDate %s, course duration %s, studentsCount: %s\n",
//                    courseActiveOnDate[0],
//                    courseActiveOnDate[1],
//                    courseActiveOnDate[2],
//                    courseActiveOnDate[3],
//                    courseActiveOnDate[4]);
//
//        }

//        List<Object[]> allStudentsAndCoursesEnrolledInAndTotalPrice =
//                this.studentService.getAllStudentsAndCoursesEnrolledInAndTotalPrice();
//
//        for (Object[] student: allStudentsAndCoursesEnrolledInAndTotalPrice) {
//            System.out.printf("Name: %s, number of courses: %s, total price: %s, average price %s\n",
//                    student[0],
//                    student[1],
//                    student[2],
//                    student[3]);
//        }

    }

    private void seedDatabase()throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");

        List<Student> students = new ArrayList<>();

        Student student = new Student();
        student.setName("Iva");
        student.setRegistrationDate(new Date());
        student.setPhoneNumber("08855546299");
        studentService.save(student);
        students.add(student);

        Student student2 = new Student();
        student2.setName("LrX");
        student2.setRegistrationDate(formatter.parse("15/01/2011"));
        studentService.save(student2);
        students.add(student2);

        Student student3 = new Student();
        student3.setName("Mira");
        student3.setPhoneNumber("0245694115");
        student3.setRegistrationDate(formatter.parse("20/05/2013"));
        studentService.save(student3);
        students.add(student3);

        Student student4 = new Student();
        student4.setName("Mira");
        student4.setRegistrationDate(formatter.parse("25/11/2016"));
        studentService.save(student4);
        students.add(student4);

        Student student5 = new Student();
        student5.setName("Mira");
        student5.setRegistrationDate(formatter.parse("15/10/2006"));
        studentService.save(student5);
        students.add(student5);

        Course course1 = new Course();
        course1.setName("Java DB");
        course1.setStartDate(formatter.parse("10/22/2013"));
        course1.setEndDate(formatter.parse("06/06/2014"));
        course1.setPrice(BigDecimal.valueOf(400));
        course1.setStudents(new HashSet<>(students.subList(0,2)));
        courseService.save(course1);

        Course course2 = new Course();
        course2.setName("Java DB i oshte neshto");
        course2.setStartDate(formatter.parse("12/12/2013"));
        course2.setEndDate(formatter.parse("12/06/2014"));
        course2.setPrice(BigDecimal.valueOf(300));
        course2.setStudents(new HashSet<>(students.subList(0,2)));
        courseService.save(course2);

        Course course3 = new Course();
        course3.setName("Java DB2");
        course3.setStartDate(formatter.parse("05/12/2013"));
        course3.setEndDate(formatter.parse("05/06/2014"));
        course3.setPrice(BigDecimal.valueOf(250));
        course3.setStudents(new HashSet<>(students.subList(0,2)));
        courseService.save(course3);

        Homework homework = new Homework();
        homework.setContent("Java Fundamentals");
        homework.setContentType(ContentType.PDF);
        homework.setSubmissionDate(new Date());
        homework.setStudent(student3);
        homeworkService.save(homework);

        Homework homework2 = new Homework();
        homework2.setContent("Java Principles");
        homework2.setContentType(ContentType.ZIP);
        homework2.setSubmissionDate(new Date());
        homework2.setStudent(student);
        homeworkService.save(homework2);

        Homework homework3 = new Homework();
        homework3.setContent("Java Principles2");
        homework3.setContentType(ContentType.ZIP);
        homework3.setSubmissionDate(new Date());
        homework3.setStudent(student5);
        homeworkService.save(homework3);

        Homework homework4 = new Homework();
        homework4.setContent("Java Principles2");
        homework4.setCourse(course3);
        homework4.setContentType(ContentType.ZIP);
        homework4.setSubmissionDate(new Date());
        homework4.setStudent(student4);
        homeworkService.save(homework4);

        Resource resource1 = new Resource();
        resource1.setName("neshto");
        resource1.setCourse(course1);
        resource1.setTypeOfResource(ResourceType.DOCUMENT);
        resource1.setURL("www.neshto.com");
        resourceService.save(resource1);


        Resource resource2 = new Resource();
        resource2.setName("nishto");
        resource2.setCourse(course2);
        resource2.setTypeOfResource(ResourceType.PRESENTATION);
        resource2.setURL("www.nishto.com");
        resourceService.save(resource2);

        Resource resource3 = new Resource();
        resource3.setName("vajni neshta");
        resource3.setCourse(course3);
        resource3.setTypeOfResource(ResourceType.VIDEO);
        resource3.setURL("www.abv.bg");
        resourceService.save(resource3);

        Resource resource4 = new Resource();
        resource4.setName("Javarsko");
        resource4.setCourse(course1);
        resource4.setTypeOfResource(ResourceType.DOCUMENT);
        resource4.setURL("www.java.bg");
        resourceService.save(resource4);
    }
}
