package com.cg.online_plant_nursery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//Entity with table name = "Customer"
@Entity
@Table(name = "Customer")
public class Customer {
//Columns inside the table
	@Id
	@Column(name = "id")
	private long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String role;
	@Column
	private String password;
	@Column
	private long contactnumber;
	@Column
	private double totalamount;
//Constructors
	public Customer() {
	}
	
	public Customer(long id, String name, String email, String role, String password, long contactnumber,
			double totalamount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.contactnumber = contactnumber;
		this.totalamount = totalamount;
	}

	//Required getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	//To display the contents
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", password="
				+ password + ", contactnumber=" + contactnumber + ", totalamount=" + totalamount + "]";
	}
}
