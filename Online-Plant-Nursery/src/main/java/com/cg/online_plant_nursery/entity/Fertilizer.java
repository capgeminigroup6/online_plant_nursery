package com.cg.online_plant_nursery.entity;

import javax.persistence.*;

@Entity
	@Table(name="fertilizer")
	public class Fertilizer {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int Id;
		@Column(length=40)
		private String Name;
		@Column
		private String Type;
		@Column
		private double Price;
		@Column
		private String Description;
		@Column
		private String Image;
		public Fertilizer(int id, String name, String type, double price, String description, String image) {
			super();
			Id = id;
			Name = name;
			Type = type;
			Price = price;
			Description = description;
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
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}		
	}
