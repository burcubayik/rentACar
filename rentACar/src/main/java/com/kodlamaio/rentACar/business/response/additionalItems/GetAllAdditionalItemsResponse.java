package com.kodlamaio.rentACar.business.response.additionalItems;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllAdditionalItemsResponse {
	@NotBlank
	@NotNull
	@Size(min = 2)
	private String name;
	
	@NotNull
	@Min(0)
	private double dailyPrice;
	
}
