package com.kodlamaio.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar.business.abstracts.BrandService;
import com.kodlamaio.rentACar.business.abstracts.CarService;
import com.kodlamaio.rentACar.business.abstracts.ColorService;
import com.kodlamaio.rentACar.business.request.cars.CreateCarRequest;
import com.kodlamaio.rentACar.business.request.cars.DeleteCarRequest;
import com.kodlamaio.rentACar.business.request.cars.UpdateCarRequest;
import com.kodlamaio.rentACar.business.response.cars.GetAllCarsResponse;
import com.kodlamaio.rentACar.business.response.cars.ReadCarResponse;
import com.kodlamaio.rentACar.business.response.colors.ReadColorResponse;
import com.kodlamaio.rentACar.core.utilities.exceptions.BusinessException;
import com.kodlamaio.rentACar.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.ErrorResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;
import com.kodlamaio.rentACar.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar.dataAccess.abstracts.BrandRepository;
import com.kodlamaio.rentACar.dataAccess.abstracts.CarRepository;
import com.kodlamaio.rentACar.dataAccess.abstracts.ColorRepository;
import com.kodlamaio.rentACar.entities.concretes.Brand;
import com.kodlamaio.rentACar.entities.concretes.Car;
import com.kodlamaio.rentACar.entities.concretes.Color;

@Service
public class CarManager implements CarService {

	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private BrandService brandService;
	private ColorService colorService;

	@Autowired
	public CarManager(CarRepository carRepository, ModelMapperService modelMapperService, BrandService brandService,
			ColorService colorService) {

		this.carRepository = carRepository;
		this.modelMapperService = modelMapperService;
		this.brandService = brandService;
		this.colorService = colorService;	
	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {
		checkIfBrandExistsById(createCarRequest.getBrandId());
		checkIfColorExistsById(createCarRequest.getColorId());

		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		car.setState(1);
		checkMaxBrand(createCarRequest.getBrandId());
		this.carRepository.save(car);
		return new SuccessResult("CAR.ADDED");

	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		checkIfCarExistsById(updateCarRequest.getId());
		checkIfBrandExistsById(updateCarRequest.getBrandId());
		checkIfColorExistsById(updateCarRequest.getColorId());
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		checkMaxBrand(updateCarRequest.getBrandId(), car, updateCarRequest);
		checkMaxBrand(updateCarRequest.getBrandId());
		this.carRepository.save(car);
		return new SuccessResult("UPDATED.CAR");
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		checkIfCarExistsById(deleteCarRequest.getId());
		Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carRepository.delete(car);
		return new SuccessResult("DELETED.CAR");

	}

	@Override
	public DataResult<List<GetAllCarsResponse>> getAll() {
		getCarList();
		List<GetAllCarsResponse> response = getCarList().stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllCarsResponse>>(response);
	}
	@Cacheable("cars")
	@Override
	public DataResult<List<GetAllCarsResponse>> getByState(int state) {
		getCarList();
		List<GetAllCarsResponse> response = getCarList().stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.filter(car -> car.getState() == state).collect(Collectors.toList());
		try {
			Thread.sleep(1000*4);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SuccessDataResult<List<GetAllCarsResponse>>(response, "CAR.LISTED");
	}

	@Override
	public DataResult<List<GetAllCarsResponse>> getByBrandName(String brandName) {
		getCarList();
		List<GetAllCarsResponse> response = getCarList().stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.filter(car -> brandName.equals(car.getBrandName())).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCarsResponse>>(response, "CAR.LISTED");
	}

	@Override
	public DataResult<ReadCarResponse> getById(int id) {
		Car car = checkIfCarExistsById(id);
		ReadCarResponse readCarResponse = this.modelMapperService.forResponse().map(car, ReadCarResponse.class);
		return new SuccessDataResult<ReadCarResponse>(readCarResponse);
	}
	private boolean maxBrand(int brandId) {//isim bul doğru değil
		boolean exists = false;
		if (carRepository.getByBrandId(brandId).size() < 5) {
			exists = true;
		}

		return exists;
	}

	private Car checkIfCarExistsById(int id) {
		Car currentCar;
		try {
			currentCar = this.carRepository.findById(id).get();
		} catch (Exception e) {
			throw new BusinessException("CAR.NOT.EXİSTS");
		}
		return currentCar;

	}
	private Brand checkIfBrandExistsById(int brandId) {
		Brand currentBrand;
		try {
			currentBrand = this.brandService.getBrandById(brandId);
		} catch (Exception e) {
			throw new BusinessException("BRAND.NOT.EXİSTS");
		}
		return currentBrand;

	}
	private Color checkIfColorExistsById(int colorId) {
		Color currentColor;
		try {
			currentColor = this.colorService.getColorById(colorId);
		} catch (Exception e) {
			throw new BusinessException("COLOR.NOT.EXİSTS");
		}
		return currentColor;
	}
	private void checkMaxBrand(int id) {
		if (!maxBrand(id)) {
			throw new BusinessException("CAR.NOT.ADDED");
		}
	}
	
	private List<Car> getCarList(){
		List<Car> cars = this.carRepository.findAll();
		return cars;		}
	private void checkMaxBrand(int id, Car car, UpdateCarRequest updateCarRequest) {
		if (carRepository.getByBrandId(updateCarRequest.getBrandId()).size() == 5) {
			car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
			this.carRepository.save(car);
		}

	}

	@Override
	public Car getByCarId(int id) {
		return checkIfCarExistsById(id);
	}

	
	
	

}
