package com.rponce.Ticketify.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ExchangeTicketDTO {

	@NotEmpty(message = "Must be a qr string in the petition")
	String qr;
	
}
