package com.kodlamaio.rentACar.business.request.corporateCustomer;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCorporateCustomerRequest {
	@Min(1)
	private int corporateCustomerId;
}
