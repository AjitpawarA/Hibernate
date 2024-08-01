package hospital_app_hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFind {
	public static void main(String[] args) {
	EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entitymanagerfactory.createEntityManager();
	EntityTransaction entitytransaction=entityManager.getTransaction();
	
	
	
	Person person=entityManager.find(Person.class,510);
	System.out.println("Person id :" +person.getId());
	System.out.println("Person name :"+person.getName());
	
	
	if(person!=null) {
		List<Encounter> encounter=person.getEncounter();
		for(Encounter encounters :encounter) {
			System.out.println("============================");
			System.out.println("Encounter id :" +encounters.getId());
			System.out.println("Encounter name :" +encounters.getName());
			System.out.println("Encounter age :" +encounters.getAge());
			
			if(encounter!=null) {
				List<MedOrders> medorders = encounters.getMedorders();
				
				
				for (MedOrders medorder : medorders) {
					System.out.println("*");
					System.out.println("Medorder name:"+medorder.getName());
					System.out.println("Medorder ID:"+medorder.getId());
					
					if(medorder!=null) {
						List<Item> items = medorder.getItem();
						System.out.println(items);
						for (Item item  : items) {
							System.out.println("-------------------------");
							System.out.println("Item :"+item.getName());
						} 
					}
				}
			}
		}
		
	}

	}
}