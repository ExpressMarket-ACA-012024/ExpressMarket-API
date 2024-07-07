package com.rponce.Ticketify.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rponce.Ticketify.models.entities.Store;

public interface StoreRepository extends JpaRepository<Store, UUID>{

}
