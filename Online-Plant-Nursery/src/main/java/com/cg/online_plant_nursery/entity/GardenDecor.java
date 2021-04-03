package com.cg.online_plant_nursery.entity;

import javax.persistence.*;

@Entity
@Table(name="decor")
public class GardenDecor {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private String name;
@Column 
private String type;
@Column
private double price;
@Column
private String image;

public GardenDecor(int id, String name,String type, double price, String image) {
id = id;
name =name;
type=type;
price = price;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
}
