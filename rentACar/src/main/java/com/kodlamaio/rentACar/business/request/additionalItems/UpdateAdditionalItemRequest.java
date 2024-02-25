package com.kodlamaio.rentACar.business.request.additionalItems;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdditionalItemRequest {
	@Min(1)
	private int id;

	@NotBlank
	@Size(min = 2)
	private String name;

	@NotNull
	@Min(0)
	private double dailyPrice;
}
