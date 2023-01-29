package com.abdulkhalekomar.repository;

import com.abdulkhalekomar.entity.Salary;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface ISalaryRepository {

	@Transactional(rollbackOn = IllegalAccessException.class, dontRollbackOn = EntityExistsException.class)
	Optional<Salary> save(Salary Salary);

	Optional<Salary> getSalaryById(Long id);

	void deleteSalary(Salary Salary);

	List<Salary> getSalaryBy();

	List<Salary> getSalaryByNativeQuery();
}
