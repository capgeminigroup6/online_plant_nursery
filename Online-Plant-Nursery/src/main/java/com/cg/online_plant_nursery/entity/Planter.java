package com.cg.online_plant_nursery.entity;

import javax.persistence.*;
import javax.persistence.*;
//Entity with table name = "planter"
@Entity
	@Table(name="planter")
	public class Planter {
//Columns inside the table
		@Id
		@Column(name = "id")
		private long id;
		@Column
		private String name;
		@Column	
		private String type;
		@Column
		private double price;
		@Column
		private String image;
//Constructors
		public Planter() {
		}
		public Planter(long id, String name, String type, double price, String image) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.price = price;
			this.image = image;
		}
//Required getters and setters
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
		
		
//To display the contents
		@Override
		public String toString() {
			return "Planter [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", image=" + image
					+ "]";
		}	
		
	}
