package com.cg.online_plant_nursery.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	private long TransactionId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Customer customerID;
	@Column
	private String PaymentOption;
	@Column
	private double Amount;
	@Column
	private Date date;

	

public Transaction(long transactionId, Customer customerID, String paymentOption, double amount, Date date) {
		super();
		TransactionId = transactionId;
		this.customerID = customerID;
		PaymentOption = paymentOption;
		Amount = amount;
		this.date = date;
	}


public long getTransactionId() {
	return TransactionId;
}


public void setTransactionId(long transactionId) {
	TransactionId = transactionId;
}



public Customer getCustomerID() {
	return customerID;
}


public void setCustomerID(Customer customerID) {
	this.customerID = customerID;
}


public String getPaymentOption() {
	return PaymentOption;
}


public void setPaymentOption(String paymentOption) {
	PaymentOption = paymentOption;
}


public double getAmount() {
	return Amount;
}


public void setAmount(double amount) {
	Amount = amount;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


@Override
public String toString() {
	return "Transaction [TransactionId=" + TransactionId + ", customerID=" + customerID + ", PaymentOption="
			+ PaymentOption + ", Amount=" + Amount + ", date=" + date + "]";
}



}
