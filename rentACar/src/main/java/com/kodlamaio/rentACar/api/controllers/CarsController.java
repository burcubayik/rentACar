package com.kodlamaio.rentACar.api.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar.business.abstracts.CarService;
import com.kodlamaio.rentACar.business.request.cars.CreateCarRequest;
import com.kodlamaio.rentACar.business.request.cars.DeleteCarRequest;
import com.kodlamaio.rentACar.business.request.cars.UpdateCarRequest;
import com.kodlamaio.rentACar.business.response.cars.GetAllCarsResponse;
import com.kodlamaio.rentACar.business.response.cars.ReadCarResponse;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

	@Autowired
	private CarService carService;
	

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}

	@DeleteMapping("/delete") // neden?
	public Result delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<ReadCarResponse> getById(@RequestBody ReadCarResponse readCarResponse) {
		return this.carService.getById(readCarResponse.getId());
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllCarsResponse>> getAll() {
		return this.carService.getAll();
	}

	@GetMapping("/getbybrandandname")
	public DataResult<List<GetAllCarsResponse>> getByBrandAndColorName(String brandName) {
		return this.carService.getByBrandName(brandName);
	}

	@GetMapping("/getbystate")
	public DataResult<List<GetAllCarsResponse>> getByState(@RequestParam int state) {
		return this.carService.getByState(state);
	}

}
