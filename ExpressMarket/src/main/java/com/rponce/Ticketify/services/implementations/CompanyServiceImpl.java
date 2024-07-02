package com.rponce.Ticketify.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rponce.Ticketify.models.dtos.SaveCompanyDTO;
import com.rponce.Ticketify.models.entities.Company;
import com.rponce.Ticketify.repositories.CompanyRepository;
import com.rponce.Ticketify.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void saveCompany(SaveCompanyDTO info) throws Exception {
		Company newCompany = new Company();
		newCompany.setCompany(info.getCompany());
		newCompany.setTaxid(info.getTaxid());
		
		companyRepository.save(newCompany);
	}

	@Override
	public Company getCompanyById(UUID id) {
		
		Company company = companyRepository.findOneById(id);
		
		return company;
	}

	@Override
	public List<Company> getAllCompanies() {
		
		List<Company> companies = companyRepository.findAll();
		
		return companies;
	}

	@Override
	public void deleteCompanyById(UUID id) throws Exception {
		
		Company compToDelete = companyRepository.findOneById(id);
		
		companyRepository.delete(compToDelete);
		
	}

	@Override
	public Company getCompanyByTaxid(String taxid) {
		
		Company company = companyRepository.findOneByTaxid(taxid);
	
		return company;
	}

}
