package com.cg.online_plant_nursery.entity;

import java.util.ArrayList;
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
	public Cart() {
	}
	public Cart(long cartID, Customer customer, List<Plant> plantList, List<Seed> seedList, List<Planter> planterList,
			List<GardenDecor> gardenDecorList, List<Fertilizer> fertilizerList, double totalAmount) {
		super();
		this.cartID = cartID;
		this.customer = customer;
		this.plantList = plantList;
		this.seedList = seedList;
		this.planterList = planterList;
		this.gardenDecorList = gardenDecorList;
		this.fertilizerList = fertilizerList;
		TotalAmount = totalAmount;
	}
	public long getCartID() {
		return cartID;
	}
	public void setCartID(long cartID) {
		this.cartID = cartID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Plant> getPlantList() {
		return plantList;
	}
	public void setPlantList(List<Plant> plantList) {
		this.plantList = plantList;
	}
	public List<Seed> getSeedList() {
		return seedList;
	}
	public void setSeedList(List<Seed> seedList) {
		this.seedList = seedList;
	}
	public List<Planter> getPlanterList() {
		return planterList;
	}
	public void setPlanterList(List<Planter> planterList) {
		this.planterList = planterList;
	}
	public List<GardenDecor> getGardenDecorList() {
		return gardenDecorList;
	}
	public void setGardenDecorList(List<GardenDecor> gardenDecorList) {
		this.gardenDecorList = gardenDecorList;
	}
	public List<Fertilizer> getFertilizerList() {
		return fertilizerList;
	}
	public void setFertilizerList(List<Fertilizer> fertilizerList) {
		this.fertilizerList = fertilizerList;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", customer=" + customer + ", plantList=" + plantList + ", seedList="
				+ seedList + ", planterList=" + planterList + ", gardenDecorList=" + gardenDecorList
				+ ", fertilizerList=" + fertilizerList + ", TotalAmount=" + TotalAmount + "]";
	}
	
}
