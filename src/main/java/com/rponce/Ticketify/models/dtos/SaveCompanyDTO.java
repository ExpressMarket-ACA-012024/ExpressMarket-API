package com.rponce.Ticketify.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveCompanyDTO {
	
	@NotEmpty
	private String company;
	
	@NotEmpty
	private String taxid;

}
