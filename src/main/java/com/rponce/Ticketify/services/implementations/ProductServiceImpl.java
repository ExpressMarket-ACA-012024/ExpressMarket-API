package com.rponce.Ticketify.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rponce.Ticketify.models.dtos.CreateProductDTO;
import com.rponce.Ticketify.models.dtos.UpdateProductDTO;
import com.rponce.Ticketify.models.entities.Category;
import com.rponce.Ticketify.models.entities.Company;
import com.rponce.Ticketify.models.entities.Product;
import com.rponce.Ticketify.repositories.CategoryRepository;
import com.rponce.Ticketify.repositories.CompanyRepository;
import com.rponce.Ticketify.repositories.ProductRepository;
import com.rponce.Ticketify.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void createProduct(CreateProductDTO info) throws Exception {
		
		Category category = categoryRepository.findOneById(info.getCategory());
		Company company = companyRepository.findOneById(UUID.fromString(info.getCompany()));
		
		Product product = new Product(	
				info.getName(),
				info.getImage(),
				category,
				info.getDescription(),
				info.getPrice(),
				company
				);
		
		productRepository.save(product);
	}

	@Override
	public Product getOneById(String id) {
		
		UUID productid = UUID.fromString(id);
		Product product = productRepository.findOneById(productid);
		
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
			
		List<Product> products = productRepository.findAll();
		
		return products;
	}

	@Override
	public List<Product> getProductsByCategory(String categoryid) {
	
		Category category = categoryRepository.findOneById(categoryid);
		List<Product> productsByCat = productRepository.findByCategory(category);
		
		return productsByCat;
	}

	@Override
	public List<Product> getProductsByCompany(String companyid) {

		Company company = companyRepository.findOneById(UUID.fromString(companyid));
		List<Product> productsByComp = productRepository.findByCompany(company);
		
		return productsByComp;
	}

	@Override
	public void updateProduct(String id, UpdateProductDTO info) throws Exception {
		
		UUID productid = UUID.fromString(id);
		Product product = productRepository.findOneById(productid);
		Category category = categoryRepository.findOneById(info.getCategory());
		Company company = companyRepository.findOneById(UUID.fromString(info.getCompany()));
		
		if(info.getName()!= null) {
			product.setName(info.getName());
		}
		
		if(info.getImage()!= null) {
			product.setImage(info.getImage());
		}
		
		if(info.getDescription()!= null) {
			product.setDescription(info.getDescription());
		}
		
		if(info.getPrice() != null) {
			product.setPrice(info.getPrice());
		}
		
		if(company != null) {
			product.setCompany(company);
		}
		
		if(category != null) {
			product.setCategory(category);
		}
		
		productRepository.save(product);
	}

	@Override
	public Page<Product> getProductsByPage(String name, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(name));
		Page<Product> pageProducts = productRepository.findByNameContains(name, pageable);
		
		return pageProducts;
	}

	
	
}
