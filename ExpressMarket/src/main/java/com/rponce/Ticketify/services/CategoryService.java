package com.rponce.Ticketify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rponce.Ticketify.models.dtos.SaveCategoryDTO;
import com.rponce.Ticketify.models.entities.category;

@Service
public interface CategoryService {

	public void saveCategory(SaveCategoryDTO info) throws Exception;
	category getCategoryById(String id);
	List<category> getAllCategories();
	public void deleteCategoryById(String id) throws Exception;
	
}
