package com.cg.online_plant_nursery.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
//Entity with table name = "OrderDetails"
@Entity
@Table(name="OrderDetails")
public class OrderDetails {
//Columns inside the table
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long OrderId;
//This customerid column references to customer.id with a OneToOne type relation	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customer;
	
	@Column	
	private String PaymentOption;
	@Column
	private double Amount;
	@Column
	private LocalDateTime date;
	@Column
	private String shipping_address;
	
//Constructors
	public OrderDetails() {
	}
	
public OrderDetails(long orderId, Customer customer, String paymentOption, double amount, LocalDateTime date,
		String shipping_address) {
	super();
	OrderId = orderId;
	this.customer = customer;
	PaymentOption = paymentOption;
	Amount = amount;
	this.date = date;
	this.shipping_address = shipping_address;
}

//Required getters and setters
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime localDateTime) {
		this.date = localDateTime;
	}
	
public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	//To display the contents
	@Override
	public String toString() {
		return "OrderDetails [OrderId=" + OrderId + ", customer=" + customer + ", PaymentOption=" + PaymentOption
				+ ", Amount=" + Amount + ", date=" + date + ", shipping_address=" + shipping_address + "]";
	}
	
}
