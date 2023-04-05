package com.abdulkhalekomar;

import com.abdulkhalekomar.entity.ActiveEmployee;
import com.abdulkhalekomar.entity.Company;
import com.abdulkhalekomar.entity.EmployeeProfile;
import com.abdulkhalekomar.entity.Salary;
import com.abdulkhalekomar.service.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeService employeeService = new EmployeeService(entityManager);

        ActiveEmployee employee = new ActiveEmployee();
        employee.setFirstName("Richard");
        employee.setLastName("King");
        employee.setYearsExperience(15);

        ActiveEmployee employee2 = new ActiveEmployee();
        employee2.setFirstName("Mary");
        employee2.setLastName("Johnson");
        employee2.setYearsExperience(5);

        //set employment history
        employee.setCompanies(generateCompanies());
        employee2.setCompanies(generateCompanies());

        //create an EmployeeProfile and associate it to an Employee
        employee.setEmployeeProfile(new EmployeeProfile("rKing", "password!", "email@email.com", employee, "Software Engineer"));
        employee2.setEmployeeProfile(new EmployeeProfile("mJohns", "password234", "johndoe@email.com", employee, "Project Manager"));

        //set salaries
        employee.setSalaries(generateSalaries());
        employee2.setSalaries(generateSalaries());

        //save Employee
        employeeService.save(employee);
        employeeService.save(employee2);

        //retrieve
        employeeService.getEmployeeByExperienceNativeQuery(10).forEach((e) -> System.out.println(e.getFirstName()));
        employeeService.getEmployeeByExperienceCriteriaQuery(10).forEach(e -> System.out.println(e.getLastName()));


        entityManager.close();
        entityManagerFactory.close();
    }

    private static List<Salary> generateSalaries() {
        //create the Salaries and associate to Employee
        Salary currentSalary = new Salary(34000.00, true);
        Salary historicalSalary1 = new Salary(10000.00, false);
        Salary historicalSalary2 = new Salary(500.00, false);

        ArrayList<Salary> salaries = new ArrayList<>();
        salaries.add(currentSalary);
        salaries.add(historicalSalary1);
        salaries.add(historicalSalary2);

        return salaries;
    }

    private static List<Company> generateCompanies() {
        Company company1 = new Company("Facebook", "USA");
        Company company2 = new Company("Oracle", "USA");

        List<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        return companies;
    }
}
