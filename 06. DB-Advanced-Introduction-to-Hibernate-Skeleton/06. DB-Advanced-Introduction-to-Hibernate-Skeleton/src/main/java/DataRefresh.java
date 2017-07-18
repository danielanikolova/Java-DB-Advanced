import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query getEmployWithID = entityManager
                .createQuery("Select e from Employee as e " +
                "where e.id =4");

        List<Employee> employeeWithId = getEmployWithID.getResultList();

        for (Employee employee: employeeWithId) {
            if (employeeWithId.size()>0){
                employee.setFirstName(employee.getFirstName().toUpperCase());
                entityManager.persist(employee);
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
