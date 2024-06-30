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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "company")
@ToString(exclude = "products")
public class Company {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "role")
	private String company;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Product> products;
	
	public Company(String id, String role) {
		super();
		this.company = role;
	}
	
}
