package com.abdulkhalekomar.service;

import com.abdulkhalekomar.entity.Employee;
import com.abdulkhalekomar.repository.IEmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;


public class EmployeeService
				implements IEmployeeRepository {

	private EntityManager entityManager;

	public EmployeeService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Optional<Employee> save(Employee employee) {
		try {
			entityManager.getTransaction().begin(); // uncomment if not using @Transactional
			if (employee.getId() == null) {
				if (employee.getEmployeeProfile() != null) {
					entityManager.persist(employee.getEmployeeProfile());
				}
				entityManager.persist(employee);
			}
			else {
				employee = entityManager.merge(employee);
			}
			entityManager.getTransaction().commit(); // uncomment if not using @Transactional
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
		Query query = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.yearsExperience > :yearsExperience ORDER BY e.lastName");
		query.setParameter("yearsExperience", yearsExperience);
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByExperienceNativeQuery(Integer yearsExperience) {
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM Employees WHERE yearsExperience > :yearsExperience ORDER BY lastName", Employee.class);
		nativeQuery.setParameter("yearsExperience", yearsExperience);
		List<Employee> employeeList = nativeQuery.getResultList();
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByExperienceCriteriaQuery(Integer yearsExperience) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

		List<Employee> employees =
						entityManager.createQuery(criteriaQuery.select(employeeRoot).where(criteriaBuilder.greaterThan(employeeRoot.get("yearsExperience"), yearsExperience)))
										.getResultList();
		return employees;
	}
}
