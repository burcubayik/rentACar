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
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequest {
	@Min(1)
	private int id;
	@FutureOrPresent
	private LocalDate sentDate;
	@Future
	private LocalDate returnedDate;
	@NotEmpty
	@Min(1)
	private int carId;

}
