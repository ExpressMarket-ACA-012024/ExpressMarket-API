package com.rponce.Ticketify.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import com.rponce.Ticketify.models.entities.Category;
import com.rponce.Ticketify.models.entities.Company;
import com.rponce.Ticketify.models.entities.Product;

public interface ProductRepository extends ListCrudRepository<Product, UUID>{
	
	List<Product> findByCompany(Company company);
	List<Product> findByCategory(Category category);
	Product findOneById(UUID id);
	Page<Product> findByNameContains(String title, Pageable pageable);

}
