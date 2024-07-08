package com.rponce.Ticketify.services;

import java.util.List;
import java.util.UUID;

import com.rponce.Ticketify.models.entities.Store;

public interface StoreService {

	public List<Store> getAll();
	
	public Store getOneStore(UUID id);
	
}
