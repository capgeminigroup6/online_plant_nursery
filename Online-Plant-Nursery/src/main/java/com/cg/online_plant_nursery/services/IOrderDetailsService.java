package com.cg.online_plant_nursery.services;

import com.cg.online_plant_nursery.entity.OrderDetails;

public interface IOrderDetailsService {
	public void addOrderDetails(OrderDetails OrderDetails);
	public void updateOrderDetails(long OrderId, OrderDetails OrderDetails);
	public void deleteOrderDetails(long OrderId);
	public void getAllOrderDetails();
	public void getOrderDetailsById(long OrderId);
}
