
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Object[]> objects =
                em.createQuery("SELECT MAX(e.salary), " +
                        "e.department.name FROM Employee e " +
                        "GROUP BY e.department " +
                        "HAVING MAX(e.salary) < 30000 OR MAX(e.salary) > 70000")
                        .getResultList();

        for (Object[] object : objects) {
            System.out.println(object[1] + " - " + object[0]);
        }

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }
}
