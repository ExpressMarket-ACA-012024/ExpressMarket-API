package com.rponce.Ticketify.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateProductDTO {
	
	@NotEmpty
	private String name;

	@NotEmpty
	private String image;
	
	@NotEmpty
	private String category;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private Double price;
	
	@NotEmpty
	private String company;
}
