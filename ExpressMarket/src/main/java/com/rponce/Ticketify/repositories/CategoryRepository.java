package com.rponce.Ticketify.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.rponce.Ticketify.models.entities.category;

public interface CategoryRepository extends ListCrudRepository<category, String>{

	category findOneById();
	
}
