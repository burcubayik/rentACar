package com.kodlamaio.rentACar.business.request.maintenance;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteMaintenanceRequest {
	@Min(1)
	private int id;
}
