package ems_hibernate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    private int id;
    
    private String name;
    private String location;
    private long phoneno;
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<Employee>();

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
    
    
}
