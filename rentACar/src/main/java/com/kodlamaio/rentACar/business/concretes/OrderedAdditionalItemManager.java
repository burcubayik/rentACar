package com.kodlamaio.rentACar.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar.business.abstracts.AdditionalItemService;
import com.kodlamaio.rentACar.business.abstracts.OrderedAdditionalItemService;
import com.kodlamaio.rentACar.business.abstracts.RentalService;
import com.kodlamaio.rentACar.business.request.additionals.CreateOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.request.additionals.DeleteOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.request.additionals.UpdateOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.response.additionals.GetAllOrderedAdditionalItemsResponse;
import com.kodlamaio.rentACar.business.response.additionals.ReadOrderedAdditionalItemResponse;
import com.kodlamaio.rentACar.core.utilities.exceptions.BusinessException;
import com.kodlamaio.rentACar.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;
import com.kodlamaio.rentACar.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar.dataAccess.abstracts.OrderedAdditionalItemRepository;
import com.kodlamaio.rentACar.entities.concretes.AdditionalItem;
import com.kodlamaio.rentACar.entities.concretes.OrderedAdditionalItem;
import com.kodlamaio.rentACar.entities.concretes.Rental;

@Service
public class OrderedAdditionalItemManager implements OrderedAdditionalItemService {

	private OrderedAdditionalItemRepository orderedAdditionalItemRepository;

	private AdditionalItemService additionalItemService;

	private RentalService rentalService;

	private ModelMapperService modelMapperService;

	@Autowired
	public OrderedAdditionalItemManager(OrderedAdditionalItemRepository orderedAdditionalItemRepository,
			AdditionalItemService additionalItemService, RentalService rentalService,
			ModelMapperService modelMapperService) {

		this.orderedAdditionalItemRepository = orderedAdditionalItemRepository;
		this.additionalItemService = additionalItemService;
		this.rentalService = rentalService;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateOrderedAdditionalItemRequest createOrderedAdditionalItemRequest) {
		AdditionalItem additionalItem = this.additionalItemService
				.getByAdditionalItemId(createOrderedAdditionalItemRequest.getAdditionalItemId());
		checkIfRentalExistsById(createOrderedAdditionalItemRequest.getRentalId());
		OrderedAdditionalItem orderedAdditionalItem = this.modelMapperService.forRequest()
				.map(createOrderedAdditionalItemRequest, OrderedAdditionalItem.class);
		orderedAdditionalItem.setReturnDate(calculateReturnDate(createOrderedAdditionalItemRequest.getPickUpDate(),
				createOrderedAdditionalItemRequest.getTotalDays()));

		orderedAdditionalItem
				.setTotalPrice(calculateTotalPrice(createOrderedAdditionalItemRequest.getTotalDays(), additionalItem));

		this.orderedAdditionalItemRepository.save(orderedAdditionalItem);
		return new SuccessResult("ADDED.ADDITIONAL");
	}

	@Override
	public Result update(UpdateOrderedAdditionalItemRequest updateOrderedAdditionalItemRequest) {
		checkIfOrderedAdditionalItemExistsById(updateOrderedAdditionalItemRequest.getId());
		checkIfRentalExistsById(updateOrderedAdditionalItemRequest.getRentalId());
		AdditionalItem additionalItem = this.additionalItemService
				.getByAdditionalItemId(updateOrderedAdditionalItemRequest.getAdditionalItemId());
		OrderedAdditionalItem orderedAdditionalItem = this.modelMapperService.forRequest()
				.map(updateOrderedAdditionalItemRequest, OrderedAdditionalItem.class);
		orderedAdditionalItem.setReturnDate(calculateReturnDate(updateOrderedAdditionalItemRequest.getPickUpDate(),
				updateOrderedAdditionalItemRequest.getTotalDays()));

		orderedAdditionalItem
				.setTotalPrice(calculateTotalPrice(updateOrderedAdditionalItemRequest.getTotalDays(), additionalItem));

		this.orderedAdditionalItemRepository.save(orderedAdditionalItem);
		return new SuccessResult("UPDATED.ADDITIONAL");
	}

	@Override
	public Result delete(DeleteOrderedAdditionalItemRequest deleteOrderedAdditionalItemRequest) {
		checkIfOrderedAdditionalItemExistsById(deleteOrderedAdditionalItemRequest.getId());
		OrderedAdditionalItem additional = this.modelMapperService.forRequest().map(deleteOrderedAdditionalItemRequest,
				OrderedAdditionalItem.class);
		this.orderedAdditionalItemRepository.delete(additional);
		return new SuccessResult("DELETED.ADDITIONAL");
	}

	@Override
	public DataResult<ReadOrderedAdditionalItemResponse> getById(int id) {
		OrderedAdditionalItem orderedAdditionalItem = checkIfOrderedAdditionalItemExistsById(id);
		ReadOrderedAdditionalItemResponse response = this.modelMapperService.forResponse().map(orderedAdditionalItem,
				ReadOrderedAdditionalItemResponse.class);
		return new SuccessDataResult<ReadOrderedAdditionalItemResponse>(response);
	}

	@Override
	public DataResult<List<GetAllOrderedAdditionalItemsResponse>> getAll() {
		List<OrderedAdditionalItem> additionals = this.orderedAdditionalItemRepository.findAll();
		List<GetAllOrderedAdditionalItemsResponse> response = additionals.stream()
				.map(additional -> this.modelMapperService.forResponse().map(additional,
						GetAllOrderedAdditionalItemsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllOrderedAdditionalItemsResponse>>(response);
	}

	@Override
	public List<OrderedAdditionalItem> getByOrderedAdditionalItemsId(int id) {
		return this.orderedAdditionalItemRepository.findByRentalId(id);
	}

	@Override
	public OrderedAdditionalItem getOrderedAdditionalItemById(int id) {

		return checkIfOrderedAdditionalItemExistsById(id);
	}

	private LocalDate calculateReturnDate(LocalDate pickUpDate, int totalDays) {
		LocalDate returnvalue = pickUpDate.plusDays(totalDays);
		return returnvalue;

	}

	private double calculateTotalPrice(int totalDays, AdditionalItem additionalItem) {
		double totalPrice = totalDays * additionalItem.getDailyPrice();

		return totalPrice;
	}

	private OrderedAdditionalItem checkIfOrderedAdditionalItemExistsById(int id) {
		OrderedAdditionalItem currentOrderedAdditionalItem;
		try {
			currentOrderedAdditionalItem = this.orderedAdditionalItemRepository.findById(id).get();
		} catch (Exception e) {
			throw new BusinessException("ORDERED.ADDITIONAL.ITEM.NOT.EXISTS");
		}
		return currentOrderedAdditionalItem;
	}

	private Rental checkIfRentalExistsById(int id) {
		Rental rental;
		try {
			rental = this.rentalService.getByRentalId(id);
		} catch (Exception e) {
			throw new BusinessException("RENTAL.NOT.EXISTS");
		}
		return rental;
	}

}
