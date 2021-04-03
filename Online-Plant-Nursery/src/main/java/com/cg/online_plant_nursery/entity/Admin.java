package com.cg.online_plant_nursery.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin implements Serializable{
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerID")
	private Customer customer;

	public Admin(Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer= customer;
	}

	@Override
	public String toString() {
		return "Admin [customer=" + customer + "]";
	}
	
}
