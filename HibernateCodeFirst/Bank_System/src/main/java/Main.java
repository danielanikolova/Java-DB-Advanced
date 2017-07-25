import dependencies.EntityManagerFactoryContainer;

import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = EntityManagerFactoryContainer.getInstance();
        entityManagerFactory.close();
    }

}
