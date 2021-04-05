package com.cg.online_plant_nursery.entity;

import javax.persistence.*;

@Entity
	@Table(name="planter")
	public class Planter {
		@Id
		@Column(name = "id")
		private int Id;
		@Column
		private String Name;
		@Column	
		private String Type;
		@Column
		private double Price;
		@Column
		private String Image;
		public Planter() {
		}
		public Planter(int id, String name, String type, double price, String image) {
			super();
			Id = id;
			Name = name;
			Type = type;
			Price = price;
			Image = image;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
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
		@Override
		public String toString() {
			return "Planter [Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", Price=" + Price + ", Image=" + Image
					+ "]";
		}	
		
	}
