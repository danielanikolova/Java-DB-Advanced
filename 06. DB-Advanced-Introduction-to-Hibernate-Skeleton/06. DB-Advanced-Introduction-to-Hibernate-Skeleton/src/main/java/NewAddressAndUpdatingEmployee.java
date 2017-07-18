import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class NewAddressAndUpdatingEmployee {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);

        Employee employee = (Employee) entityManager
                .createQuery("select e from Employee e where e.lastName = 'Nakov'")
                .getSingleResult();
        employee.setAddress(address);

        System.out.println(employee.getAddress().getText());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
