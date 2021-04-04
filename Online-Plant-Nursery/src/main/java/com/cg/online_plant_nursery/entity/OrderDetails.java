package com.cg.online_plant_nursery.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="OrderDetails")
public class OrderDetails {
	@Id
	private long OrderId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customer;
	@Column	
	private String PaymentOption;
	@Column
	private double Amount;
	@Column
	private Date date;
	public OrderDetails() {
	}
	public OrderDetails(long orderId, Customer customer, String paymentOption, double amount, Date date) {
		super();
		OrderId = orderId;
		this.customer = customer;
		PaymentOption = paymentOption;
		Amount = amount;
		this.date = date;
	}
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "OrderDetails [OrderId=" + OrderId + ", customer=" + customer + ", PaymentOption=" + PaymentOption
				+ ", Amount=" + Amount + ", date=" + date + "]";
	}

	
}
