package com.ty.hibernateCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestOneRecord {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Student s =entityManager.find(Student.class, 4);
		if(s!=null) {
			System.out.println("Name: "+s.getNam());
			System.out.println("Roll:"+s.getRol());
			System.out.println("Height:"+s.getHeight());
			System.out.println("Email: "+ s.getEmail());
		}
		else {
			System.out.println("No student is present in the dbfor given roll");
		}
		
	}
}
