import entities.WizardDeposits;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        WizardDeposits dumledore = new WizardDeposits();
        dumledore.setFirstName("Albus");
        dumledore.setLastName("Dumbledore");
        dumledore.setAge(150);
        dumledore.setMagicWandCreator("Antoich Peverell");
        dumledore.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 20);
        Date depositStart = calendar.getTime();
        dumledore.setDepositStartDate(depositStart);
        calendar.set(2020,10,20);
        Date depositEnd = calendar.getTime();
        dumledore.setDepositExpirationDate(depositEnd);
        dumledore.setDepositAmount(BigDecimal.valueOf(2000.24));
        dumledore.setDepositCharge(BigDecimal.valueOf(0.2));
        dumledore.setDepositExpired(false);

        entityManager.persist(dumledore);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
