import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory
                                ("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String inputTown = scanner.nextLine();


        Query addressQuery = entityManager
                .createQuery("select a from Address  as a where a.town.name = :townName");
        addressQuery.setParameter("townName", inputTown);

        List<Address> addresses = addressQuery.getResultList();
        Town town = addresses.get(0).getTown();
        entityManager.getTransaction().begin();

        for (Address address:addresses) {
            for (Employee employee: address.getEmployees()) {
                employee.setAddress(null);
            }
            entityManager.flush();
            entityManager.remove(address);
        }
        entityManager.remove(town);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
