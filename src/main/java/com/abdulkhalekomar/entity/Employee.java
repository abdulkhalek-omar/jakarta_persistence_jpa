package com.abdulkhalekomar.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee
				implements Serializable {

	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String experience;
	@Column
	private Integer yearsExperience;
	@Transient
	private Double totalCompensation;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "employee_id")
	private List<Salary> salaries = new ArrayList<>();
	@Column
	private Company company;

	@OneToOne(mappedBy = "employee")
	private EmployeeProfile employeeProfile;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long id;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String experience, Integer yearsExperience, Double totalCompensation, List<Salary> salaries, Company company, Long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.yearsExperience = yearsExperience;
		this.totalCompensation = totalCompensation;
		this.salaries = salaries;
		this.company = company;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(Integer yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public Double getTotalCompensation() {
		return totalCompensation;
	}

	public void setTotalCompensation(Double totalCompensation) {
		this.totalCompensation = totalCompensation;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public EmployeeProfile getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(EmployeeProfile employeeProfile) {
		this.employeeProfile = employeeProfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
