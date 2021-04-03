package com.cg.online_plant_nursery.services;

import com.cg.online_plant_nursery.entity.OrderDetails;

public interface IOrderDetailsService {
	public void addTransaction(OrderDetails OrderDetails);
	public void updateTransaction(long TransactionId, OrderDetails OrderDetails);
	public void deleteTransaction(long TransactionId);
	public void getAllTransaction();
	public void getTransactionById(long TransactionId);
}
