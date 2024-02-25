package com.kodlamaio.rentACar.business.request.colors;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest {
	@NotBlank
	@Size(min = 2)
	private String name;

}
