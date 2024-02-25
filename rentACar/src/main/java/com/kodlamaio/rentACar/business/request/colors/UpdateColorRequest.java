package com.kodlamaio.rentACar.business.request.colors;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateColorRequest {
	private int id;
	@NotBlank
	@Size(min = 2)
	private String name;

}
