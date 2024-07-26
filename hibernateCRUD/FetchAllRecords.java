package com.ty.hibernateCRUD;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchAllRecords {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		System.out.println(entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT s from Student s");

		List<Student> students = query.getResultList();
		System.out.println("----------------------");
		for (Student student : students) {
			System.out.println("Name:" + student.getNam());
			System.out.println("Roll:" + student.getRol());
			System.out.println("Email:" + student.getEmail());
			System.out.println("Height:" + student.getHeight());
			System.out.println("-----------------------");
		}
	}
}
