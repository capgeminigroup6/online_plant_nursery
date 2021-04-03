package com.cg.online_plant_nursery.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	private long cartID;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customer;
	
	@Column
	@ElementCollection
	private List<Plant> plantList = new ArrayList<>();
	@Column
	@ElementCollection
	private List<Seed> seedList = new ArrayList<>();
	@Column
	@ElementCollection
	private List<Planter> planterList = new ArrayList<>();
	@Column
	@ElementCollection
	private List<GardenDecor> gardenDecorList = new ArrayList<>();
	@Column
	@ElementCollection
	private List<Fertilizer> fertilizerList = new ArrayList<>();
	@Column
	private double TotalAmount;
	
}
