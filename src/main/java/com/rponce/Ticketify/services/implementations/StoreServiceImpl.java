package com.rponce.Ticketify.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rponce.Ticketify.models.entities.Store;
import com.rponce.Ticketify.repositories.StoreRepository;
import com.rponce.Ticketify.services.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public List<Store> getAll() {
		return storeRepository.findAll();
	}

	@Override
	public Store getOneStore(UUID id) {
		return storeRepository.findById(id).orElse(null);
	}

}
