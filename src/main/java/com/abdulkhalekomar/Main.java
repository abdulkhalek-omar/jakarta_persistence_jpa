package com.abdulkhalekomar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;


public class Main {

	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.close();
		entityManagerFactory.close();
	}

	//	public static void main(String[] args) {
	//
	////		Employee employee1 = new Employee("Omar", "AK", "Java, Kotlin, JPA");
	////		Employee employee2 = new Employee("Jan", "BK", "C#, C++, .Net Core");
	////		Company company = new Company("AK solutions GmbH", "MH", "45468", "DE");
	////		Salary developerSalary = new Salary("", 1, 1000, 1200.50, 1500.99, true, "Developer");
	//
	//	}
}
