package one_to_one_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Car car = new Car();
		car.setId(1);
		car.setCost(20000);
		car.setName("Swift");
		

		Engine engine = new Engine();
		engine.setId(101);
		engine.setType("K2");
		engine.setCc(1400);
		car.setEngine(engine);
		
		
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(engine);
		entityTransaction.commit();
	}
}
