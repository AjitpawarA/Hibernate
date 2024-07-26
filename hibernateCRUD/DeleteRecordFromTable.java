package com.ty.hibernateCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteRecordFromTable {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Student s =entityManager.find(Student.class, 1);
		
		
		if(s!=null) {
			entityTransaction.begin();
			entityManager.remove(s);
			entityTransaction.commit();
			System.out.println("RECORD DELETED");
		}
		else {
			System.out.println("Record not present");
		}
	}
}
