package com.kodlamaio.rentACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar.business.abstracts.RentalService;
import com.kodlamaio.rentACar.business.request.rental.CreateCorporateCustomerRentalRequest;
import com.kodlamaio.rentACar.business.request.rental.CreateIndividualCustomerRentalRequest;
import com.kodlamaio.rentACar.business.request.rental.DeleteRentalRequest;
import com.kodlamaio.rentACar.business.request.rental.UpdateIndividualCustomerRentalRequest;
import com.kodlamaio.rentACar.business.response.rentals.GetAllRentalsResponse;
import com.kodlamaio.rentACar.business.response.rentals.ReadRentalResponse;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;
import com.kodlamaio.rentACar.entities.concretes.Rental;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
	@Autowired
	RentalService rentalService;

	@PostMapping("/addindividualrental")
	public Result addIndividualRental(@RequestBody @Valid CreateIndividualCustomerRentalRequest createIndividualRentalRequest) {

		return this.rentalService.addIndividualCustomerRental(createIndividualRentalRequest);

	}
	@PostMapping("/addcorporaterental")
	public Result addCorporateRental(@RequestBody @Valid CreateCorporateCustomerRentalRequest createCorporateRentalRequest) {

		return this.rentalService.addCorporateCustomerRental(createCorporateRentalRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateIndividualCustomerRentalRequest updateRentalRequest) {
		return this.rentalService.updateIndividualCustomerRental(updateRentalRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteRentalRequest deleteRentalRequest) {
		return this.rentalService.delete(deleteRentalRequest);

	}

	@GetMapping("/getbyid")
	public DataResult<ReadRentalResponse> getById(@RequestParam int id) {
		return this.rentalService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllRentalsResponse>> getAll() {
		return this.rentalService.getAll();
	}
}
