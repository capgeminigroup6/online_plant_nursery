package com.cg.online_plant_nursery.entity;

import javax.persistence.*;
//Entity with table name = "planter"
@Entity
	@Table(name="planter")
	public class Planter {
//Columns inside the table
		@Id
		@Column(name = "id")
		private long Id;
		@Column
		private String Name;
		@Column	
		private String Type;
		@Column
		private double Price;
		@Column
		private String Image;
//Constructors
		public Planter() {
		}
		public Planter(long id, String name, String type, double price, String image) {
			super();
			Id = id;
			Name = name;
			Type = type;
			Price = price;
			Image = image;
		}
//Required getters and setters
		public long getId() {
			return Id;
		}
		public void setId(long id) {
			Id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}
//To display the contents
		@Override
		public String toString() {
			return "Planter [Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", Price=" + Price + ", Image=" + Image
					+ "]";
		}	
		
	}
