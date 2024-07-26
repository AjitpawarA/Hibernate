package one_to_one_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFetchRecord {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Car car = entityManager.find(Car.class, 1);
		System.out.println("==================================");
		if(car!=null) {
			System.out.println("car  id :"+car.getId());
			System.out.println("car  name :"+car.getName());
			System.out.println("car  cost :"+car.getCost());
			
			System.out.println("car engine id :"+car.getEngine().getId());
			System.out.println("car engine type :"+car.getEngine().getType());
		}
	}
}
