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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
