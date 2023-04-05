package com.abdulkhalekomar.entity;

import jakarta.persistence.Entity;
import java.util.List;


@Entity
public class RetiredEmployee
        extends Employee {
    private Boolean pension;
    private Integer yearsOfService;

    public RetiredEmployee() {
    }

    public RetiredEmployee(Boolean pension, Integer yearsOfService) {
        this.pension = pension;
        this.yearsOfService = yearsOfService;
    }

    public RetiredEmployee(String firstName, String lastName, String experience, Integer yearsExperience, Double totalCompensation, List<Salary> salaries, List<Company> companies,
                           Long id, Boolean pension, Integer yearsOfService) {
        super(firstName, lastName, experience, yearsExperience, totalCompensation, salaries, companies, id);
        this.pension = pension;
        this.yearsOfService = yearsOfService;
    }

    public Boolean getPension() {
        return pension;
    }

    public void setPension(Boolean pension) {
        this.pension = pension;
    }

    public Integer getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(Integer yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
}
