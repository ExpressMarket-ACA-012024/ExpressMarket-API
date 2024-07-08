package com.rponce.Ticketify.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rponce.Ticketify.models.dtos.SaveCategoryDTO;
import com.rponce.Ticketify.models.entities.Category;
import com.rponce.Ticketify.repositories.CategoryRepository;
import com.rponce.Ticketify.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void saveCategory(SaveCategoryDTO info) throws Exception {
		
		Category newCategory = new Category();
		newCategory.setId(info.getId_category());
		newCategory.setCategory(info.getCategory());
		
		categoryRepository.save(newCategory);
	}

	@Override
	public Category getCategoryById(String id) {

		Category cat = categoryRepository.findOneById(id);
		
		return cat;
	}

	@Override
	public List<Category> getAllCategories() {
	
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategoryById(String id) throws Exception {
		
		Category catToDelete = categoryRepository.findOneById(id);
		
		categoryRepository.delete(catToDelete);
		
	}

}
