package com.kodlamaio.rentACar.business.request.brands;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	
	@NotNull
	private int id;
	
	@NotBlank
	@Size(min = 2)
	private String name;
}
