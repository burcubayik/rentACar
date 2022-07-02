package com.kodlamaio.rentACar.business.abstracts;

import java.util.List;

import com.kodlamaio.rentACar.business.request.additionals.CreateOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.request.additionals.DeleteOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.request.additionals.UpdateOrderedAdditionalItemRequest;
import com.kodlamaio.rentACar.business.response.additionals.GetAllOrderedAdditionalItemsResponse;
import com.kodlamaio.rentACar.business.response.additionals.ReadOrderedAdditionalItemResponse;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;
import com.kodlamaio.rentACar.entities.concretes.OrderedAdditionalItem;

public interface OrderedAdditionalItemService {

	Result add(CreateOrderedAdditionalItemRequest createOrderedAdditionalItemRequest);

	Result update(UpdateOrderedAdditionalItemRequest updateOrderedAdditionalItemRequest);

	Result delete(DeleteOrderedAdditionalItemRequest deleteOrderedAdditionalItemRequest);

	DataResult<ReadOrderedAdditionalItemResponse> getById(int id);

	DataResult<List<GetAllOrderedAdditionalItemsResponse>> getAll();
	
	
	public OrderedAdditionalItem getOrderedAdditionalItemById(int id);

	List<OrderedAdditionalItem> getByOrderedAdditionalItemsId(int id);

}
