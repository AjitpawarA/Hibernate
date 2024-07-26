package com.ty.hibernateCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestInsert {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student s = new Student();
		s.setRol(4);
		s.setNam("Harshya");
		s.setHeight(170);
		s.setEmail("harsah@gmail.com");

		entityTransaction.begin();

		entityManager.persist(s);

		entityTransaction.commit();

		System.out.println("DATA SAVED");

	}
}
