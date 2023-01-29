package com.abdulkhalekomar.service;

import com.abdulkhalekomar.entity.Employee;
import com.abdulkhalekomar.repository.IEmployeeRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;


public class EmployeeService
				implements IEmployeeRepository {

	private EntityManager entityManager;

	public EmployeeService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	//	@Transactional
	public Optional<Employee> save(Employee employee) {
		try {
//			entityManager.getTransaction().begin(); // uncomment if not using @Transactional
			if (employee.getId() == null) {
				if (employee.getEmployeeProfile() != null) {
					entityManager.persist(employee.getEmployeeProfile());
				}
				entityManager.persist(employee);
			}
			else {
				employee = entityManager.merge(employee);
			}
//			entityManager.getTransaction().commit(); // uncomment if not using @Transactional
			return Optional.of(employee);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee != null ? Optional.of(employee) : Optional.empty();
	}

	@Override
	public void deleteEmployee(Employee employee) {
		entityManager.getTransaction().begin(); // uncomment if not using @Transactional
		if (entityManager.contains(employee)) {
			entityManager.remove(employee);
		}
		else {
			entityManager.merge(employee);
		}
		entityManager.getTransaction().commit(); // uncomment if not using @Transactional
	}

	@Override
	public List<Employee> getEmployeeByExperience(Integer yearsExperience) {
		return null;
	}

	@Override
	public List<Employee> getEmployeeByExperienceNativeQuery(Integer yearsExperience) {
		return null;
	}
}
