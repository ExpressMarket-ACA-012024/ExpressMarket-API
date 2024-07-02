package com.rponce.Ticketify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rponce.Ticketify.models.dtos.CreateProductDTO;
import com.rponce.Ticketify.models.dtos.PageDTO;
import com.rponce.Ticketify.models.entities.Product;
import com.rponce.Ticketify.services.ProductService;
import com.rponce.Ticketify.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@PostMapping("/save")
	private ResponseEntity<?> saveProduct(@ModelAttribute @Valid CreateProductDTO infoProd, BindingResult validation){
		
		if(validation.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validation.getFieldErrors()), HttpStatus.BAD_REQUEST
					);
		}
		
		try {
			productService.createProduct(infoProd);
			return new ResponseEntity<>("Product Succesfully Created!", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	private ResponseEntity<?> getProductById(@PathVariable(name = "id")String id){
		
		Product productToFind = productService.getOneById(id);
		
		if(productToFind == null) {
			return new ResponseEntity<>("Product could not be found", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(productToFind, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	private ResponseEntity<?> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		
		if(products == null) {
			return new ResponseEntity<>("There are no products to Show", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	@GetMapping("/get/page")
	private ResponseEntity<?> getProductsByPage(
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
			)
	{
		Page<Product> products = productService.getProductsByPage(name, page, size);
		PageDTO<Product> response = new PageDTO<> (
				products.getContent(),
				products.getNumber(),
				products.getSize(),
				products.getTotalElements(),
				products.getTotalPages()
				);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/{companyid}")
	private ResponseEntity<?> getProductsByCompany(@PathVariable(name = "companyid") String companyid){
	
		List<Product> products = productService.getProductsByCompany(companyid);
		
		if(products == null) {
			return new ResponseEntity<>("Company doesn't have any Products", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/get/{categoryid}")
	private ResponseEntity<?> getProductsByCategory(@PathVariable(name = "categoryid") String categoryid){
	
		List<Product> products = productService.getProductsByCategory(categoryid);
		
		if(products == null) {
			return new ResponseEntity<>("Category doesn't have any Products", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
