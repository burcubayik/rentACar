package com.kodlamaio.rentACar.business.request.cars;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

	private int id;
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
