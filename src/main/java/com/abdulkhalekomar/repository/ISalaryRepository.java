package com.abdulkhalekomar.repository;

import com.abdulkhalekomar.entity.Salary;

import java.util.List;
import java.util.Optional;


public interface ISalaryRepository {

	Optional<Salary> save(Salary Salary);

	Optional<Salary> getSalaryById(Long id);

	void deleteSalary(Salary Salary);

	List<Salary> getSalaryBy();

	List<Salary> getSalaryByNativeQuery();
}
