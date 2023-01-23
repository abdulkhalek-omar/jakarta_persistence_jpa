package com.abdulkhalekomar;

import com.abdulkhalekomar.entity.Company;
import com.abdulkhalekomar.entity.Employee;
import com.abdulkhalekomar.entity.EmployeeProfile;
import com.abdulkhalekomar.entity.Salary;
import com.abdulkhalekomar.service.CompanyService;
import com.abdulkhalekomar.service.EmployeeService;
import com.abdulkhalekomar.service.SalaryService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;


public class Main {

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EmployeeService employeeService = new EmployeeService(entityManager);
		CompanyService companyService = new CompanyService(entityManager);
		SalaryService salaryService = new SalaryService(entityManager);

		//		public Employee(String firstName, String lastName, String experience, Integer yearsExperience, Double totalCompensation, Long id)
		//		public Company(String name, String city, String zipcode, String country, Long id) {
		//		public Salary(Company company, Integer level, Integer bonusPercentage, Double startingSalary, Double currentSalary, boolean activeFlag, String title, Long id) {
		//      public EmployeeProfile(String username, String password, String email, String title, Employee employee)
		Employee employee1 = new Employee("Omar", "AK", "Java, Kotlin, JPA", 4, 1500.00, new Salary(54000.00, true), new Company("MyCompany"), 1L);
		employee1.setEmployeeProfile(new EmployeeProfile("Username", "Password", "email@gmail.com", "Software Engineer", employee1, 1L));
		Employee employee2 = new Employee("Jan", "BK", "C#, C++, .Net Core", 3, 1400.00, new Salary(54000.00, true), new Company("MyCompany"), 2L);
		Company company = new Company("AK solutions GmbH", "MH", "45467", "DE", 1L);
		Salary developerSalary = new Salary(company, 1, 1000, 1200.50, 1500.99, true, "Developer", 1L);

		employeeService.save(employee1);
		employeeService.save(employee2);
		companyService.save(company);
		salaryService.save(developerSalary);

		Optional<Employee> retrievedEmployee = employeeService.getEmployeeById(2L);
		retrievedEmployee.get().setLastName("Jonson");
		employeeService.save(retrievedEmployee.get());

		employeeService.deleteEmployee(employee2);

		entityManager.close();
		entityManagerFactory.close();
	}
}
