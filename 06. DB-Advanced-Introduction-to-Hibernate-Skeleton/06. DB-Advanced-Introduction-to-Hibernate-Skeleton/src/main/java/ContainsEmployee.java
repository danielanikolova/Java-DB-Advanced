import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        entityManager.getTransaction().begin();

        Query nameQuery = entityManager.createQuery
                ("SELECT e FROM Employee as e WHERE CONCAT(e.firstName,' ',e.lastName) = :name");

        nameQuery.setParameter("name", name);

        List<Employee> employees = nameQuery.getResultList();


            if (employees.size()>0){
                System.out.println("Yes");
            }else    System.out.println("No");



        entityManager.close();
        entityManagerFactory.close();



    }
}
