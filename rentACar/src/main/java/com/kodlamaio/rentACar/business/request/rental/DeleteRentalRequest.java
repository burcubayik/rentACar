package com.kodlamaio.rentACar.business.request.rental;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRentalRequest {
	@Min(1)
	@NotNull
	private int id;

}
