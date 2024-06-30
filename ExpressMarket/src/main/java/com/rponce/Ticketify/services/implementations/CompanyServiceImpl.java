package com.rponce.Ticketify.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.rponce.Ticketify.models.entities.Company;
import com.rponce.Ticketify.repositories.CompanyRepository;
import com.rponce.Ticketify.services.CompanyService;

public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void saveCompany(String company) throws Exception {
		Company newCompany = new Company();
		newCompany.setCompany(company);
		
		companyRepository.save(newCompany);
	}

	@Override
	public Company getCompanyById(UUID id) {
		
		Company company = companyRepository.findOneById();
		
		return company;
	}

	@Override
	public List<Company> getAllCompanies() {
		
		List<Company> companies = companyRepository.findAll();
		
		return companies;
	}

	@Override
	public void deleteCompanyById(UUID id) throws Exception {
		
		Company compToDelete = companyRepository.findById(id).orElse(null);
		
		companyRepository.delete(compToDelete);
		
	}

}
