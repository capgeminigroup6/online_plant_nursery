package com.cg.online_plant_nursery.entity;


import javax.persistence.*;
//Entity with table name = "admin"
@Entity
@Table(name = "admin")
public class Admin{
//Columns inside the table
	@Id
	@Column(name = "id")
	private long id;
//This customerID column references to customer.id with a OneToOne type relation
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerID",referencedColumnName = "id")
	private Customer customer;
//Constructors
	public Admin() {
	}

	public Admin(long id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}
//Required getters and setters
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
//To display the contents
	@Override
	public String toString() {
		return "Admin [id=" + id + ", customer=" + customer + "]";
	}
	
	
}
