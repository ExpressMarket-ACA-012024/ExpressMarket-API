package com.rponce.Ticketify.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rponce.Ticketify.models.entities.User;
import com.rponce.Ticketify.services.StoreService;
import com.rponce.Ticketify.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	private ResponseEntity<?> getAll(){
		try {
			return new ResponseEntity<>(storeService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/user/save")
	private ResponseEntity<?> updateUserStore(@RequestParam(name = "idStore") String idStore){
		
		if (idStore==null) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		
		UUID uuidStore = UUID.fromString(idStore);
		
		User userToUpdate = userService.findUserAuthenticated();
		
		try {
			userService.UpdateStore(userToUpdate, uuidStore);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
