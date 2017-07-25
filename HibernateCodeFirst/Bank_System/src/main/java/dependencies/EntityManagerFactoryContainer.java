package dependencies;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryContainer {

    private static EntityManagerFactory emfInstance;

    public static EntityManagerFactory getInstance() {

        if (emfInstance == null) {
            emfInstance = Persistence.createEntityManagerFactory("PersistenceUnit");
        }

        return emfInstance;
    }

    private EntityManagerFactoryContainer() {};


}
