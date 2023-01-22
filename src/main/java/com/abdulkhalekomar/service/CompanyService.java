package com.abdulkhalekomar.service;

import com.abdulkhalekomar.entity.Company;
import com.abdulkhalekomar.repository.ICompanyRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;


public class CompanyService
				implements ICompanyRepository {

	private EntityManager entityManager;

	public CompanyService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Optional<Company> save(Company company) {
		try {
			entityManager.getTransaction().begin();
			if (company.getId() == null) {
				entityManager.persist(company);
			}
			else {
				company = entityManager.merge(company);
			}
			entityManager.getTransaction().commit();

			return Optional.of(company);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Optional<Company> getCompanyById(Long id) {
		Company company = entityManager.find(Company.class, id);
		return company != null ? Optional.of(company) : Optional.empty();
	}

	@Override
	public void deleteCompany(Company company) {
		entityManager.getTransaction().begin();
		if (entityManager.contains(company)) {
			entityManager.remove(company);
		}
		else {
			entityManager.merge(company);
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Company> getCompanyBy() {
		return null;
	}

	@Override
	public List<Company> getCompanyByNativeQuery() {
		return null;
	}
}
