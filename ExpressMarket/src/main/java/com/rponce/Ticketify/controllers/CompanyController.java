package com.rponce.Ticketify.controllers;

import java.util.List;
import java.util.UUID;

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
import com.rponce.Ticketify.models.entities.Company;
import com.rponce.Ticketify.models.entities.category;
import com.rponce.Ticketify.services.CompanyService;
import com.rponce.Ticketify.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
@CrossOrigin("*")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@PostMapping("/save/{name}")
	private ResponseEntity<?> SaveCompany (@PathVariable(name = "id") String Id){
		
	UUID uuid = UUID.fromString(Id);
	Company companyExists = companyService.getCompanyById(uuid);
		
		if(companyExists == null) {
			return new ResponseEntity<>("Company already exists", HttpStatus.BAD_REQUEST);
		}
		
		try {
			companyService.saveCompany(uuid.toString());
			return new ResponseEntity<>(uuid.toString(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	private ResponseEntity<?> getCompanyById(@PathVariable(name = "id") String Id){
		UUID uuid = UUID.fromString(Id);
		Company company = companyService.getCompanyById(uuid);
		
		if(company == null) {
			return new ResponseEntity<>("Company doesn't exists", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	private ResponseEntity<?> getAllCompanies(){
		
		List<Company> companyList = companyService.getAllCompanies();
		
		if(companyList == null) {
			return new ResponseEntity<>("There aren't categories registered", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(companyList, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<?> deleteCompanyById(@PathVariable(name = "id") String Id){
		
		UUID uuid = UUID.fromString(Id);
		
		try {
			companyService.deleteCompanyById(uuid);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
