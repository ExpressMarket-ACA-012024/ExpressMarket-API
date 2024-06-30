package com.rponce.Ticketify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rponce.Ticketify.models.dtos.SaveCategoryDTO;
import com.rponce.Ticketify.models.entities.category;
import com.rponce.Ticketify.services.CategoryService;
import com.rponce.Ticketify.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@PostMapping("/save")
	private ResponseEntity<?> SaveCategory (@ModelAttribute @Valid SaveCategoryDTO infoCat, BindingResult validation){
		
		category categoryExists = categoryService.getCategoryById(infoCat.getId_category());
		
		if(categoryExists == null) {
			return new ResponseEntity<>("Category already exists", HttpStatus.BAD_REQUEST);
		}
		
		if(validation.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validation.getFieldErrors()), HttpStatus.BAD_REQUEST
					);
		}
		
		try {
			categoryService.saveCategory(infoCat);
			return new ResponseEntity<>(infoCat, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	private ResponseEntity<?> getCategoryById(@PathVariable(name = "id") String Id){
		
		category Category = categoryService.getCategoryById(Id);
		
		if(Category == null) {
			return new ResponseEntity<>("Category doesn't exists", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(Category, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	private ResponseEntity<?> getAllCategories(){
		
		List<category> categoryList = categoryService.getAllCategories();
		
		if(categoryList == null) {
			return new ResponseEntity<>("There aren't categories registered", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(categoryList, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<?> deleteCategoryById(@PathVariable(name = "id") String Id){
		
		try {
			categoryService.deleteCategoryById(Id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
