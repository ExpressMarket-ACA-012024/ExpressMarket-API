package com.rponce.Ticketify.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.rponce.Ticketify.models.entities.Company;

public interface CompanyRepository extends ListCrudRepository<Company, UUID>{

	Company findOneById(UUID id);
	Company findOneByTaxid(String taxid);
	
}
