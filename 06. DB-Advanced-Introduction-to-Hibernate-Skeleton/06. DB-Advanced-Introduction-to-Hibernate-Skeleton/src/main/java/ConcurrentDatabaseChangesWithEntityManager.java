import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class ConcurrentDatabaseChangesWithEntityManager {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        entityManager1.getTransaction().begin();
        entityManager2.getTransaction().begin();

        List<Employee> firstList = entityManager1
                .createQuery("select e from Employee e " +
                        "where e.id = 5").getResultList();
        List<Employee> secList = entityManager2
                .createQuery("select e from Employee e " +
                        "where e.id = 5").getResultList();


        Employee e = firstList.get(0);
        Employee e2 = secList.get(0);
        entityManager1.lock(e, LockModeType.PESSIMISTIC_WRITE);
        entityManager2.lock(e2,LockModeType.PESSIMISTIC_WRITE);
        e.setFirstName("Emma");
        e2.setFirstName("Mimi");

//        entityManager1.flush();
        entityManager1.persist(e);

//        entityManager2.flush();
        entityManager2.persist(e2);

        entityManager1.getTransaction().commit();
        entityManager2.getTransaction().commit();

        entityManager1.close();
        entityManager2.close();
        entityManagerFactory.close();


    }
}
