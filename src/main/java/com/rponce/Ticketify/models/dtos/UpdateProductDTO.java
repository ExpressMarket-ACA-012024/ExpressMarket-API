package com.rponce.Ticketify.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateProductDTO {

	@NotEmpty
	private String name;

	@NotEmpty
	private String image;
	
	@NotEmpty
	private String category;
	
	@NotEmpty
	private String description;
	
	private Double price;
	
	@NotEmpty
	private String company;
	
	@NotEmpty
	private String product;
	
}
