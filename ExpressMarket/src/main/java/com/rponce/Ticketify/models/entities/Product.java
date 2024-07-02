package com.rponce.Ticketify.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	
	public Product(String name, String image, Category category,
			String description, Float price, Company company) {
		super();
		this.name = name;
		this.image = image;
		this.category = category;
		this.description = description;
		this.price = price;
		this.company = company;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@JoinColumn(name = "id_category", nullable = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Float price;
	
	@JoinColumn(name = "id_company", nullable = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;
	
}
