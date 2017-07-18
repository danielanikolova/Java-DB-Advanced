import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Department> departments = entityManager
                .createQuery("select d from Department d " +
                        "where d.name in ('Engineering', 'Tool Design', 'Marketing','Information Services')")
                .getResultList();


        for (Department currentDep: departments) {
            currentDep.getEmployees().stream()
                    .forEach(e-> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));


            currentDep.getEmployees().stream()
                    .forEach(e-> System.out.printf("Name:%s, Salary: %.2f\n",
                            e.getFirstName()+" " + e.getLastName(),
                            e.getSalary()));
        }

        entityManager.flush();
//        entityManager.persist(departments);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
