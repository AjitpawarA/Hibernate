package com.ty.hibernateCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecordinDB {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student s =entityManager.find(Student.class, 1);
		if(s!=null){

			s.setHeight(14);
			
			entityTransaction.begin();
			
			entityManager.persist(s);
			
			entityTransaction.commit();
			
			System.out.println("Updated the recoder ");

		}
		else {
			System.out.println("RECORD NOT PRESENT");
		}
	}
}
