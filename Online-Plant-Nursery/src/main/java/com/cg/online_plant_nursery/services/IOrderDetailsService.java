package com.cg.online_plant_nursery.services;

import com.cg.online_plant_nursery.entity.OrderDetails;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateOrderException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.OrderDetailsNotFoundException;

public interface IOrderDetailsService {
	public void addOrderDetails(OrderDetails OrderDetails) throws DuplicateOrderException,CustomreNotFoundException;
	public void updateOrderDetails(long OrderId, OrderDetails OrderDetails) throws OrderDetailsNotFoundException,CustomreNotFoundException;
	public void deleteOrderDetails(long OrderId) throws OrderDetailsNotFoundException;
	public void getAllOrderDetails() throws ListIsEmptyException;
	public void getOrderDetailsById(long OrderId) throws OrderDetailsNotFoundException;
}
