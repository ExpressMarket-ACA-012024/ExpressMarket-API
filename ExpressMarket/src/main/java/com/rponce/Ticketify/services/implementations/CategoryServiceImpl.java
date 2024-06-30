package com.rponce.Ticketify.services.implementations;

import java.util.List;

import com.rponce.Ticketify.models.dtos.SaveCategoryDTO;
import com.rponce.Ticketify.models.entities.category;
import com.rponce.Ticketify.repositories.CategoryRepository;
import com.rponce.Ticketify.services.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	
	@Override
	public void saveCategory(SaveCategoryDTO info) throws Exception {
		
		category newCategory = new category();
		newCategory.setId(info.getId_category());
		newCategory.setCategory(info.getCategory());
		
		categoryRepository.save(newCategory);
	}

	@Override
	public category getCategoryById(String id) {

		category cat = categoryRepository.findById(id).orElse(null);
		
		return cat;
	}

	@Override
	public List<category> getAllCategories() {
	
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategoryById(String id) throws Exception {
		
		category catToDelete = categoryRepository.findById(id).orElse(null);
		
		categoryRepository.delete(catToDelete);
		
	}

}
