package com.kodlamaio.rentACar.business.request.users;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

	@Size(min = 2)
	@NotBlank
	@NotEmpty
	@NotNull
	private String firstName;

	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 2)
	private String lastName;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 11,max = 11)
	private String nationality;
	@NotBlank
	@NotEmpty
	@NotNull
	@Email
	private String email;

	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 4, max = 16)
	private String password;
	
	private int birthDate;

}
