package com.cg.online_plant_nursery.services;

import com.cg.online_plant_nursery.entity.Transaction;

public interface ITransactionService {
	public void addTransaction(Transaction transaction);
	public void updateTransaction(long TransactionId, Transaction transaction);
	public void deleteTransaction(long TransactionId);
	public void getAllTransaction();
	public void getTransactionById(long TransactionId);
}
