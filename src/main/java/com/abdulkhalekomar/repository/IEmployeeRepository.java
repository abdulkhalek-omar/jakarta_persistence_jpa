package com.abdulkhalekomar.repository;

import com.abdulkhalekomar.entity.Employee;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface IEmployeeRepository {

	@Transactional(rollbackOn = IllegalAccessException.class, dontRollbackOn = EntityExistsException.class)
	Optional<Employee> save(Employee employee);

	Optional<Employee> getEmployeeById(Long id);

	@Transactional(rollbackOn = IllegalAccessException.class, dontRollbackOn = EntityExistsException.class)
	void deleteEmployee(Employee employee);

	List<Employee> getEmployeeByExperience(Integer yearsExperience);

	List<Employee> getEmployeeByExperienceNativeQuery(Integer yearsExperience);

	List<Employee> getEmployeeByExperienceCriteriaQuery(Integer yearsExperience);
}
