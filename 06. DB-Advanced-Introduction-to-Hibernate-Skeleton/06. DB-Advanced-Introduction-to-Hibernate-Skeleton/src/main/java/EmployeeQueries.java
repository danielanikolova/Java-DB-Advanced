import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeQueries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Step 1

        List<String> employeesNames = entityManager
                .createQuery("select e.firstName from Employee e " +
                        "where e.salary>50000").getResultList();

        for (String name: employeesNames) {
            System.out.println(name);
        }

        //Step 2

        List<Employee> employeesFromDep = entityManager
                .createQuery("select e from Employee e " +
                        "inner join Department d on e.department.id = d.id " +
                        "where d.name = 'Research and Development' " +
                "order by e.salary asc, e.firstName desc").getResultList();

        for (Employee employee: employeesFromDep) {
            System.out.printf("%s %s from %s - $%.2f\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }


        entityManager.close();
        entityManagerFactory.close();

    }

}

