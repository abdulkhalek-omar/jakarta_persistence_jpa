package com.abdulkhalekomar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;


@Entity
public class EmployeeProfile
				implements Serializable {

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String email;

	@Column
	private String title;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profile_id")
	private Long id;

	public EmployeeProfile() {
	}

	public EmployeeProfile(String username, String password, String email, String title, Employee employee, Long id) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.title = title;
		this.employee = employee;
		this.id = id;
	}

	public EmployeeProfile(String username, String password, String email, String title, Employee employee) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.title = title;
		this.employee = employee;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
