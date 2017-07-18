import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee manager = (Employee) entityManager.createQuery
                ("SELECT e FROM Employee as e where e.id = 1")
                .getSingleResult();

        Department training = new Department();
        training.setName("Training");
        training.setManager(manager);

        Town burgas = new Town();
        burgas.setName("Burgas");

        Address addressOne = new Address();
        addressOne.setTown(burgas);
        addressOne.setText("Mladost");

        Address addressTwo = new Address();
        addressTwo.setTown(burgas);
        addressTwo.setText("G.M.Dimitrov");

        Address addressThree = new Address();
        addressThree.setTown(burgas);
        addressThree.setText("Lyulin");

        Employee pesho
                =new Employee();
        pesho.setFirstName("Pesho");
        pesho.setLastName("Petrov");
        pesho.setMiddleName("Petrov");
        pesho.setManager(manager);
        pesho.setDepartment(training);
        pesho.setJobTitle("Java");
        pesho.setAddress(addressOne);
        pesho.setSalary(new BigDecimal("50000"));
        Date peshoHireDate = new Date();
        pesho.setHireDate(new Timestamp(peshoHireDate.getTime()));

        Employee gosho
                =new Employee();
        gosho.setFirstName("Gosho");
        gosho.setLastName("Kirilov");
        gosho.setMiddleName("Kirilov");
        gosho.setManager(manager);
        gosho.setDepartment(training);
        gosho.setJobTitle("Java DB");
        gosho.setAddress(addressTwo);
        gosho.setSalary(new BigDecimal("5000000"));
        Date goshoHireDate = new Date();
        gosho.setHireDate(new Timestamp(goshoHireDate.getTime()));

        Employee mimi
                =new Employee();
        mimi.setFirstName("Maria");
        mimi.setLastName("Kirilova");
        mimi.setMiddleName("Kirilova");
        mimi.setManager(manager);
        mimi.setDepartment(training);
        mimi.setJobTitle("C++");
        mimi.setAddress(addressThree);
        mimi.setSalary(new BigDecimal("55000"));
        Date mimiHireDate = new Date();
        mimi.setHireDate(new Timestamp(mimiHireDate.getTime()));

        Employee ivan
                =new Employee();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Ivanov");
        ivan.setMiddleName("Ivanov");
        ivan.setManager(manager);
        ivan.setDepartment(training);
        ivan.setJobTitle("C#");
        ivan.setAddress(addressThree);
        ivan.setSalary(new BigDecimal("55000"));
        Date ivanHireDate = new Date();
        ivan.setHireDate(new Timestamp(ivanHireDate.getTime()));

        Employee stamat
                =new Employee();
        stamat.setFirstName("Stamat");
        stamat.setLastName("Stamatov");
        stamat.setMiddleName("Stamatov");
        stamat.setManager(manager);
        stamat.setDepartment(training);
        stamat.setJobTitle("JavaScript");
        stamat.setAddress(addressTwo);
        stamat.setSalary(new BigDecimal("55000"));
        Date stamatHireDate = new Date();
        stamat.setHireDate(new Timestamp(stamatHireDate.getTime()));


        entityManager.getTransaction().begin();

        entityManager.persist(training);
        entityManager.persist(burgas);
        entityManager.persist(addressOne);
        entityManager.persist(addressTwo);
        entityManager.persist(addressThree);
        entityManager.persist(pesho);
        entityManager.persist(gosho);
        entityManager.persist(mimi);
        entityManager.persist(ivan);
        entityManager.persist(stamat);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

}
