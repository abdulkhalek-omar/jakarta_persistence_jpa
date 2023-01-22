package com.abdulkhalekomar.repository;

import com.abdulkhalekomar.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface IEmployeeRepository {

	Optional<Employee> save(Employee employee);

	Optional<Employee> getEmployeeById(Long id);

	void deleteEmployee(Employee employee);

	List<Employee> getEmployeeByExperience(Integer yearsExperience);

	List<Employee> getEmployeeByExperienceNativeQuery(Integer yearsExperience);
}
