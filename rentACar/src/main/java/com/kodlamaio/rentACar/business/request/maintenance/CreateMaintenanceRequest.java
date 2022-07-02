package com.kodlamaio.rentACar.business.request.maintenance;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
