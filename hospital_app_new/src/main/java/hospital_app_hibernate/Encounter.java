package hospital_app_hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	private int id;
	private String name;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="my_branch_id")
	private Branch branch;
	
	@ManyToOne
	@JoinColumn(name="my_person_id")
	private Person person;
	
	@OneToMany(mappedBy = "encounter")
	private List<MedOrders> medorders;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<MedOrders> getMedorders() {
		return medorders;
	}

	public void setMedorders(List<MedOrders> medorders) {
		this.medorders = medorders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
	
	

}
