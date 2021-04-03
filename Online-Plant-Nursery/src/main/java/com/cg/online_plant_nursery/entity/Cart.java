package com.cg.online_plant_nursery.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartID;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Customer customerID;
	@ElementCollection
	private List<Plant> plantList;
	@ElementCollection
	private List<Seed> seedList;
	@ElementCollection
	private List<Planter> planterList;
	@ElementCollection
	private List<GardenDecor> gardenDecorList;
	@ElementCollection
	private List<Fertilizer> fertilizerList;
	@Column
	private double TotalAmount;
}
