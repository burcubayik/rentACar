package com.kodlamaio.rentACar.business.response.individualCustomers;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadIndividualCustomerResponse {
	@Min(1)
	private int individualCustomerId;
}
