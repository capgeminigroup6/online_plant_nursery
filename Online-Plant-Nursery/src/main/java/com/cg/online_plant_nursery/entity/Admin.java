package com.cg.online_plant_nursery.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin implements Serializable{
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Customer customerID;

	public Admin(Customer customerID) {
		super();
		this.customerID = customerID;
	}

	public Customer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Admin [customerID=" + customerID + "]";
	}
	
}
