package com.rponce.Ticketify.services;

import java.util.List;
import java.util.UUID;

import com.rponce.Ticketify.models.entities.Company;

public interface CompanyService {

	public void saveCompany(String company) throws Exception;
	Company getCompanyById(UUID id);
	List<Company> getAllCompanies();
	public void deleteCompanyById(UUID id) throws Exception;
	
}
