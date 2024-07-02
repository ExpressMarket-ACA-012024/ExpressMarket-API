package com.rponce.Ticketify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rponce.Ticketify.models.dtos.SaveCategoryDTO;
import com.rponce.Ticketify.models.entities.Category;

public interface CategoryService {

	public void saveCategory(SaveCategoryDTO info) throws Exception;
	Category getCategoryById(String id);
	List<Category> getAllCategories();
	public void deleteCategoryById(String id) throws Exception;
	
}
