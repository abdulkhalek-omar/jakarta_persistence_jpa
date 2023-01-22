package com.abdulkhalekomar.repository;

import com.abdulkhalekomar.entity.Company;

import java.util.List;
import java.util.Optional;


// isolate the persistence logic for each entity using Repository pattern
public interface ICompanyRepository {

	Optional<Company> save(Company company);

	Optional<Company> getCompanyById(Long id);

	void deleteCompany(Company Company);

	List<Company> getCompanyBy();

	List<Company> getCompanyByNativeQuery();
}