package emsDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ems_hibernate.Employee;
import ems_hibernate.Project;

public class EmployeeDAO {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

	static EntityManager entityManager = entityManagerFactory.createEntityManager();

	static EntityTransaction transaction = entityManager.getTransaction();

	public void saveEmployee(Employee employee) {
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

	public void assignProjectToEmployee(int employeeId, int projectId) {
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		Project project = entityManager.find(Project.class, projectId);
		if (employee != null && project != null) {
			employee.getProjects().add(project);
			project.getEmployees().add(employee);
			entityManager.persist(employee);
			entityManager.persist(project);
			transaction.commit();
		}
	}

	public Employee getEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	public void updateEmployee(Employee employee) {
		entityManager.getTransaction().begin();
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
	}

	public void deleteEmployee(int id) {
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityManager.remove(employee);
		}
		entityManager.getTransaction().commit();
	}
}
