package emsDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ems_hibernate.Project;

public class ProjectDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");

    EntityManager entityManager = emf.createEntityManager();
    public void saveProject(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }

    public Project getProject(int id) {
        Project project = entityManager.find(Project.class, id);
        return project;
    }
    public void updateProject(Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
    }

    public void deleteProject(int id) {
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, id);
        if (project != null) {
            entityManager.remove(project);
        }
        entityManager.getTransaction().commit();
    }
}
