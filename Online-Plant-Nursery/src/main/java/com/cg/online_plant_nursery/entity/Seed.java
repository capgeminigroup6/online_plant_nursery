package com.cg.online_plant_nursery.entity;

import javax.persistence.*;

@Entity
@Table(name="seed")
public class Seed {
@Id
@Column(name = "id")
private long id;
@Column
private String name;
@Column
private double price;
@Column
private int seedsperpacket;
@Column 
private String description;
@Column 
private String image;
public Seed() {
}
public Seed(long id, String name, double price, int seedsperpacket, String description, String image) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.seedsperpacket = seedsperpacket;
	this.description = description;
	this.image = image;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getSeedsperpacket() {
	return seedsperpacket;
}
public void setSeedsperpacket(int seedsperpacket) {
	this.seedsperpacket = seedsperpacket;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Seed [id=" + id + ", name=" + name + ", price=" + price + ", seedsperpacket=" + seedsperpacket
			+ ", description=" + description + ", image=" + image + "]";
}



}
