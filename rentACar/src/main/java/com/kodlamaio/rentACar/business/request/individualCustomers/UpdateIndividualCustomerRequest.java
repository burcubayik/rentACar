package com.kodlamaio.rentACar.business.request.individualCustomers;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIndividualCustomerRequest {
	@Min(1)
	private int individualCustomerId;
	@NotBlank
	@NotNull
	private String firstName;

	@NotBlank
	@NotNull
	private String lastName;

	@NotBlank
	@NotNull
	private String nationality;


	@NotNull
	private int birthDate;

	@Email
	private String email;

	@NotBlank
	@NotNull
	private String password;

}
