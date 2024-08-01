package hospital_app_hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	private int id;
	private String name;
	private int drcount;
	
	@OneToMany(mappedBy = "hospital")
	private List<Branch> branch;

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

	public int getDrcount() {
		return drcount;
	}

	public void setDrcount(int drcount) {
		this.drcount = drcount;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	
	
	
	
	
	
	

}
