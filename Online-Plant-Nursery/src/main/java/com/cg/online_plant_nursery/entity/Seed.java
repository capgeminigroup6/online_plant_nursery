package com.cg.online_plant_nursery.entity;

import javax.persistence.*;

@Entity
@Table(name="seed")
public class Seed {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private String name;
@Column
private double price;
@Column
private int seedsPerPacket;
@Column 
private String description;
@Column 
private String image;


public Seed(int id, String name, double price, int seedsPerPacket, String description, String image) {

id = id;
name =name;
price = price;
seedsPerPacket=seedsPerPacket;
description=description;
image=image;
}
public int getId() {
	return id;
}
public void setId(int id) {
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
public int getSeedsPerPacket() {
	return seedsPerPacket;
}
public void setSeedsPerPacket(int seedsPerPacket) {
	this.seedsPerPacket = seedsPerPacket;
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
}
