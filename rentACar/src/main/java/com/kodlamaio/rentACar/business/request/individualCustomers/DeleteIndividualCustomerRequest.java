package com.kodlamaio.rentACar.business.request.individualCustomers;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteIndividualCustomerRequest {
	@Min(1)
	private int individualCustomerId;
}
