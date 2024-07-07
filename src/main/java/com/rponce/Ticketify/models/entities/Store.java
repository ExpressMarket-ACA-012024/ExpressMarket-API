package com.rponce.Ticketify.models.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "store")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "latitud")
	private Float latitud;
	
	@Column(name = "longitud")
	private Float longitud;
	
	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<User> users;

	public Store(String description, Float latitud, Float longitud) {
		super();
		this.description = description;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
}
