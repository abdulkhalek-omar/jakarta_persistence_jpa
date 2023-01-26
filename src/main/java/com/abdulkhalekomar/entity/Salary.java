package com.abdulkhalekomar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "salaries")
public class Salary
				implements Serializable {

	@Column
	private Company company;
	@Column
	private Integer level;
	@Column
	private Integer bonusPercentage;
	@Column
	private Double startingSalary;
	@Column
	private Double currentSalary;
	@Column
	private boolean activeFlag;
	@Column
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "salary_id")
	private Long id;

	public Salary() {
	}

	public Salary(Company company, Integer level, Integer bonusPercentage, Double startingSalary, Double currentSalary, boolean activeFlag, String title, Employee employee,
					Long id) {
		this.company = company;
		this.level = level;
		this.bonusPercentage = bonusPercentage;
		this.startingSalary = startingSalary;
		this.currentSalary = currentSalary;
		this.activeFlag = activeFlag;
		this.title = title;
		this.employee = employee;
		this.id = id;
	}

	public Salary(Company company, Integer level, Integer bonusPercentage, Double startingSalary, Double currentSalary, boolean activeFlag, String title, Long id) {
		this.company = company;
		this.level = level;
		this.bonusPercentage = bonusPercentage;
		this.startingSalary = startingSalary;
		this.currentSalary = currentSalary;
		this.activeFlag = activeFlag;
		this.title = title;
		this.id = id;
	}

	public Salary(Double currentSalary, boolean activeFlag) {
		this.currentSalary = currentSalary;
		this.activeFlag = activeFlag;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getBonusPercentage() {
		return bonusPercentage;
	}

	public void setBonusPercentage(Integer bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}

	public Double getStartingSalary() {
		return startingSalary;
	}

	public void setStartingSalary(Double startingSalary) {
		this.startingSalary = startingSalary;
	}

	public Double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}


