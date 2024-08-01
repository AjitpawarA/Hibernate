package hospital_app_hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	@Id
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="my_item_id"),inverseJoinColumns = @JoinColumn(name="my_medorder_id"))
	private List<MedOrders> medorders;

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

	public List<MedOrders> getMedorders() {
		return medorders;
	}

	public void setMedorders(List<MedOrders> medorders) {
		this.medorders = medorders;
	}
	

}
