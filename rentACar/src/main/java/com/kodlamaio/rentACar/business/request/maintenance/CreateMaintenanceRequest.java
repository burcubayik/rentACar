package com.kodlamaio.rentACar.business.request.maintenance;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaintenanceRequest {
	@FutureOrPresent
	private LocalDate dateSent;
	@Future
	private LocalDate dateReturned;
	@Min(1)
	private int carId;

}
