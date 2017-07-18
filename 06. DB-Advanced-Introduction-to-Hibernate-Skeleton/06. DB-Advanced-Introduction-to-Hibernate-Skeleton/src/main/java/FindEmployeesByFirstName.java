import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory
                                ("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String inputPattern = scanner.nextLine();


        Query getEmployeeNames = entityManager
                .createQuery("select e from Employee e " +
                        "where e.firstName like :pattern");
        getEmployeeNames.setParameter("pattern", inputPattern  + "%");

        List<Employee> employees = getEmployeeNames.getResultList();

        employees.forEach(e-> System.out.printf("%s %s - %s - ($%.2f)\n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));

        entityManager.close();
        entityManagerFactory.close();

    }
}
