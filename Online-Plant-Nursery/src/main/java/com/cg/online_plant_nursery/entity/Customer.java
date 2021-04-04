package com.cg.online_plant_nursery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@Column(name = "id")
	private long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private int contactnumber;
	@Column
	private double totalamount;
	public Customer() {
	}
	public Customer(long id, String name, String email, String password, int contactnumber, double totalamount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactnumber = contactnumber;
		this.totalamount = totalamount;
	}
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
	public int getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(int contactnumber) {
		this.contactnumber = contactnumber;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contactnumber=" + contactnumber + ", totalamount=" + totalamount + "]";
	}
	
}
