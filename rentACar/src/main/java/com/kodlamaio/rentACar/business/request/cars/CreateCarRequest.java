package com.kodlamaio.rentACar.business.request.cars;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	@NotEmpty
	@NotBlank
	private String description;
	@NotNull
	@Min(0)
	private double dailyPrice;
	@Min(1)
	private int brandId;
	@Min(1)
	private int colorId;
	@NotBlank
	@NotEmpty
	private String plate;
	@NotNull
	@Min(0)
	private int kilometer;
	@Min(0)
	@Max(1900)
	@NotNull
	private int minFindex;

}
