package com.cg.online_plant_nursery.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin{
	@Id
	@Column(name = "id")
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerID",referencedColumnName = "id")
	private Customer customer;

	public Admin() {
	}

	public Admin(long id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", customer=" + customer + "]";
	}
	
	
}
