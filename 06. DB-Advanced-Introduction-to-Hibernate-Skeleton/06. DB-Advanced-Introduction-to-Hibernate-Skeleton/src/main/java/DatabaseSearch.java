import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class DatabaseSearch {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory
                                ("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Address> addresses = entityManager
                .createQuery("select distinct  a from Address as a " +
                        "order by a.employees.size desc, a.town.name asc")
                .setMaxResults(10)
                .getResultList();

        entityManager.getTransaction().begin();

        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees\n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }
            //Part 2
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        Query resultEmployee = entityManager
                .createQuery("select e from Employee e " +
                        "where e.id = :id ");
        resultEmployee.setParameter("id", id);

        List<Employee> e = resultEmployee.getResultList();

        for (Employee employee: e) {
            System.out.printf("FirstName: %s, LastName: %s, JobTitle: %s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle());
            employee.getProjects().stream().sorted((a,b)-> (a.getName().compareTo(b.getName())))
                    .forEach(k -> System.out.printf("Project name: %s\n", k.getName()));
        }

//        Part3

        List<Integer> projectsIds = entityManager
                .createNativeQuery("select p.project_id from projects as p " +
                        "where YEAR(p.start_date)>=2001 and YEAR(p.start_date)<=2003 ")
                .getResultList();

        Query employeesQuery = entityManager
                .createQuery("select e from Employee as e " +
                        "inner join e.projects as p " +
                        "where p.id in (:ids)");

        employeesQuery.setParameter("ids", projectsIds);

        List<Employee> employees = employeesQuery.getResultList();
        for (Employee employee:employees) {
            System.out.printf("%s %s - Manager: %s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getManager().getFirstName());

            for (Project project: employee.getProjects()) {
                System.out.printf("---Name: %s, Start date: %s, End date: %s\n",
                        project.getName(),
                        project.getStartDate(),
                        project.getEndDate());
            }
        }

        //Part 4

        Query getDepartmentsQuery = entityManager
                .createQuery("select d from Department as d " +
                "where d.employees.size> 5 order by d.employees.size asc");

        List<Department> departments = getDepartmentsQuery.getResultList();

        for (Department department : departments) {
            System.out.printf("--%s - Manager: %s, Employees: %d\n",
                    department.getName(),
                    department.getManager().getLastName(),
                    department.getEmployees().size());
        }

        entityManager.close();
        entityManagerFactory.close();


    }
}