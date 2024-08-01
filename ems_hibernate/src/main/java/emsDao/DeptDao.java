package emsDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ems_hibernate.Department;

public class DeptDao {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public void saveDepartment(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
    }

    public Department getDepartment(int id) {
        Department department = entityManager.find(Department.class, id);
        return department;
    }

    public void updateDepartment(Department department) {
        entityManager.getTransaction().begin();
        entityManager.merge(department);
        entityManager.getTransaction().commit();
    }

    public void deleteDepartment(int id) {
        entityManager.getTransaction().begin();
        Department department = entityManager.find(Department.class, id);
        if (department != null) {
            entityManager.remove(department);
        }
        entityManager.getTransaction().commit();
    }
}
