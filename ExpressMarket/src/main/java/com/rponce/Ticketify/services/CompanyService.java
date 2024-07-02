package com.rponce.Ticketify.services;

import java.util.List;
import java.util.UUID;

import com.rponce.Ticketify.models.dtos.SaveCompanyDTO;
import com.rponce.Ticketify.models.entities.Company;

public interface CompanyService {

	public void saveCompany(SaveCompanyDTO info) throws Exception;
	Company getCompanyById(UUID id);
	Company getCompanyByTaxid(String taxid);
	List<Company> getAllCompanies();
	public void deleteCompanyById(UUID id) throws Exception;
	
}
