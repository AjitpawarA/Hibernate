package hospital_app_hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HospitalController {
	public static void main(String[] args) {
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		;
		EntityTransaction entitytransaction = entitymanager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setId(10);
		hospital.setName("Sahyadri");
		hospital.setDrcount(10);
		// ---------------------------------------------------------------
		Branch branch = new Branch();
		branch.setId(110);
		branch.setName("Pune");
		branch.setFloor(10);

		List<Branch> branches = new ArrayList<Branch>();
		branches.add(branch);
		hospital.setBranch(branches);
		branch.setHospital(hospital);

		// -------------------------------------------------------------------
		Encounter encounter = new Encounter();
		encounter.setId(210);
		encounter.setName("Neha");
		encounter.setAge(22);

		encounter.setBranch(branch);
		// ----------------------------------------------------------------------

		Address address = new Address();
		address.setId(310);
		address.setPlace("Pune");
		address.setBranch(branch);
		branch.setAddress(address);
		address.setBranch(branch);

		// ----------------------------------------------------------------------
		MedOrders medorder = new MedOrders();
		medorder.setId(410);
		medorder.setName("paracetamol");
		medorder.setMfgdate("16-07-2002");

		// ---------------------------------------------------------------------------
		Item item = new Item();
		item.setId(610);
		item.setName("Tablets");

		List<Item> items = new ArrayList<Item>();
		items.add(item);
		medorder.setItem(items);
		medorder.setEncounter(encounter);
		// ----------------------------------------------------------------------------

		List<MedOrders> medorders = new ArrayList<MedOrders>();
		medorders.add(medorder);
		encounter.setMedorders(medorders);
		item.setMedorders(medorders);
		medorder.setItem(items);

		// ------------------------------------------------------------------------
		Person person = new Person();
		person.setId(510);
		person.setName("Ajit");

		List<Encounter> encounter1 = new ArrayList<Encounter>();
		person.setEncounter(encounter1);
		encounter.setPerson(person);

		// -------------------------------------------------------------------------------------------
		entitytransaction.begin();
		entitymanager.persist(hospital);
		entitymanager.persist(branch);
		entitymanager.persist(address);
		entitymanager.persist(encounter);
		entitymanager.persist(medorder);
		entitymanager.persist(item);
		entitymanager.persist(person);
		entitytransaction.commit();

	}
}