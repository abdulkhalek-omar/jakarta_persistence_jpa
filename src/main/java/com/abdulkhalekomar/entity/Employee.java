package com.abdulkhalekomar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serializable;


@Entity
@Table(name = "employees")
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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long id;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String experience, Integer yearsExperience, Double totalCompensation, Long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.yearsExperience = yearsExperience;
		this.totalCompensation = totalCompensation;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
