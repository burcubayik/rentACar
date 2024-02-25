package com.kodlamaio.rentACar.business.request.corporateCustomer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerRequest {
	private String taxNumber;

	private String corporateNumber;

	@Email
	private String email;

	@NotBlank
	@NotNull
	private String password;
}
