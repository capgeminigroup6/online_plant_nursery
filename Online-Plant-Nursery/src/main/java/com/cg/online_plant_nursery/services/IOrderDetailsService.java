package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.OrderDetails;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateOrderException;
import com.cg.online_plant_nursery.utils.InsufficiantBalanceException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;
import com.cg.online_plant_nursery.utils.OrderDetailsNotFoundException;

public interface IOrderDetailsService {
	public void addOrderDetails(long customerID,String paymentOp,long orderID) throws DuplicateOrderException,CustomreNotFoundException,InsufficiantBalanceException;
	public void updateOrderDetails(long OrderId, OrderDetails OrderDetails) throws OrderDetailsNotFoundException,CustomreNotFoundException;
	public void deleteOrderDetails(long OrderId) throws OrderDetailsNotFoundException;
	public List<OrderDetails> getAllOrderDetails(long adminID) throws ListIsEmptyException,NotAuthorizedException;
	public OrderDetails getOrderDetailsById(long OrderId) throws OrderDetailsNotFoundException;
}
