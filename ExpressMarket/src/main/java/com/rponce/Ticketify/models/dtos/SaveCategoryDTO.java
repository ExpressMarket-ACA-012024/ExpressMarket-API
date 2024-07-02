package com.rponce.Ticketify.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveCategoryDTO {

	@NotEmpty
	private String id_category;
	
	@NotEmpty
	private String category;
	
}
