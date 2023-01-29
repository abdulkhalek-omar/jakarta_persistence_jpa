package com.abdulkhalekomar.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;


@Entity
public class ActiveEmployee
				extends Employee {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Salary> salaries = new ArrayList<>();
	@Transient
	private Double totalCompensation;

	public ActiveEmployee() {
	}

	public ActiveEmployee(List<Salary> salaries, Double totalCompensation) {
		this.salaries = salaries;
		this.totalCompensation = totalCompensation;
	}

	public ActiveEmployee(String firstName, String lastName, String experience, Integer yearsExperience, Double totalCompensation, List<Salary> salaries, List<Company> companies,
					Long id, List<Salary> salaries1, Double totalCompensation1) {
		super(firstName, lastName, experience, yearsExperience, totalCompensation, salaries, companies, id);
		this.salaries = salaries1;
		this.totalCompensation = totalCompensation1;
	}

	@Override
	public List<Salary> getSalaries() {
		return salaries;
	}

	@Override
	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	@Override
	public Double getTotalCompensation() {
		return totalCompensation;
	}

	@Override
	public void setTotalCompensation(Double totalCompensation) {
		this.totalCompensation = totalCompensation;
	}
}
