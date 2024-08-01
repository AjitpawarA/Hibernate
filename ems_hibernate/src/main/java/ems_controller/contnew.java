package ems_controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ems_hibernate.Employee;

public class contnew {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

	static EntityManager entityManager = entityManagerFactory.createEntityManager();

	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Create employee with addredss, and project");
		Employee employee = new Employee();
		employee.setId(scanner.nextInt());
		employee.setName(scanner.next());
//		employee.set
	}
}
