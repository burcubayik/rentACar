package com.kodlamaio.rentACar.business.request.additionals;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderedAdditionalItemRequest {
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
