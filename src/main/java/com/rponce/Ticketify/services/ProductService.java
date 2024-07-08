package com.rponce.Ticketify.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rponce.Ticketify.models.dtos.CreateProductDTO;
import com.rponce.Ticketify.models.dtos.UpdateProductDTO;
import com.rponce.Ticketify.models.entities.Product;

public interface ProductService {
	
	public void createProduct(CreateProductDTO info) throws Exception;
	Product getOneById(String id);
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String categoryid);
	List<Product> getProductsByCompany(String companyid);
	public void updateProduct(String id, UpdateProductDTO info) throws Exception;
	Page<Product> getProductsByPage(String name, int page, int size);
	public void deleteProduct(String id) throws Exception;
	
}
