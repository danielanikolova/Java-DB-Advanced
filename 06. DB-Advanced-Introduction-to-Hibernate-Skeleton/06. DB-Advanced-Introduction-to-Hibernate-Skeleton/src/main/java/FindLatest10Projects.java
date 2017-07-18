import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Project> lastProjects = entityManager
                .createQuery("select p from Project p " +
                        "order by p.startDate desc, p.name ")
                .setMaxResults(10).getResultList();

        for (Project pr: lastProjects) {
            System.out.printf("Name: %s,Description: %s, Start Date: %s , End Date %s\n",
                    pr.getName(),
                    pr.getDescription(),
                    pr.getStartDate(),
                    pr.getEndDate());
        }



    }

}
