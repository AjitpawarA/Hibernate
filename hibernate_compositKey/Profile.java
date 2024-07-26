package com.ty.hibernate_compositKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Profile {
	@EmbeddedId
	AccountID ac;
	private String name;
	private int age;
	private String gender;

	
	public AccountID getAc() {
		return ac;
	}

	public void setAc(AccountID ac) {
		this.ac = ac;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
