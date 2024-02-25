package com.kodlamaio.rentACar.business.request.invoices;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
	@NotNull
	@NotBlank
	private String invoiceNumber;
	@Min(1)
	private int rentalId;

	

}
