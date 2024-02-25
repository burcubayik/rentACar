package com.kodlamaio.rentACar.business.request.addresses;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
	@Min(1)
	private int id;

	@NotBlank
	@NotNull
	private String deliveryAddress;

	@NotBlank
	@NotNull
	private String billAddress;

	@Min(1)
	private int userId;


}
