package com.kodlamaio.rentACar.business.request.additionals;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderedAdditionalItemRequest {
	@Min(1)
	private int id;
	@Min(1)
	private int additionalItemId;
	@Min(1)
	private int rentalId;
	@Min(1)
	@NotNull
	private int totalDays;
	@FutureOrPresent
	private LocalDate pickUpDate;
	
}
