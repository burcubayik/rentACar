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

import com.kodlamaio.rentACar.business.abstracts.OrderedAdditionalItemService;
import com.kodlamaio.rentACar.business.request.additionals.CreateOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.request.additionals.DeleteOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.request.additionals.UpdateOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.response.additionals.GetAllOrderedAdditionalItemsResponse;
import com.kodlamaio.rentACar.business.response.additionals.ReadOrderedAdditionalItemResponse;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/orderedadditionalitems")
public class OrderedAdditionalItemsController {

	private OrderedAdditionalItemService orderedAdditionalItemService;

	@Autowired
	public OrderedAdditionalItemsController(OrderedAdditionalItemService orderedAdditionalItemService) {
		this.orderedAdditionalItemService = orderedAdditionalItemService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateOrderedAdditionalItemRequest createOrderedAdditionalItemRequest) {
		return this.orderedAdditionalItemService.add(createOrderedAdditionalItemRequest);
	}

	@PostMapping("/update")
	public Result add(@RequestBody @Valid UpdateOrderedAdditionalItemRequest updateOrderedAdditionalItemRequest) {
		return this.orderedAdditionalItemService.update(updateOrderedAdditionalItemRequest);
	}

	@DeleteMapping("/delete")
	public Result add(@RequestBody DeleteOrderedAdditionalItemRequest deleteOrderedAdditionalItemRequest) {
		return this.orderedAdditionalItemService.delete(deleteOrderedAdditionalItemRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<ReadOrderedAdditionalItemResponse> getById(@RequestParam int id) {
		return this.orderedAdditionalItemService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllOrderedAdditionalItemsResponse>> getAll() {
		return this.orderedAdditionalItemService.getAll();
	}
}
