package com.kodlamaio.rentACar.business.request.rental;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor


public class CreateIndividualCustomerRentalRequest {
	@NotNull
	@FutureOrPresent
	private LocalDate pickUpDate;
	@NotNull
	@Min(1)
	private int totalDays;
	
	@Min(1)
	private int carId;
	@NotNull
	@Min(1)
	@Max(81)
	private int pickUpCityId;
	@NotNull
	@Min(1)
	@Max(81)
	private int returnCityId;
	
	@Min(1)
	private int individualCustomerId;
	

}
