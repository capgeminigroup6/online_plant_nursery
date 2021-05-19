package com.cg.online_plant_nursery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usercart")
public class UserCart {
	
		@Id
		@Column
		private long cartid;
		
		@Column
		private long customerid;
		
		@Column
		private long plantid;
		@Column
		private Integer plant_quantity;
		
		@Column
		private long seedid;
		@Column
		private Integer seed_quantity;
		
		@Column
		private long fertilizerid;
		@Column
		private Integer fertlizer_quantity;
		
		@Column
		private long planterid;
		@Column
		private Integer planter_quantity;
		
		@Column
		private long gardendecorid;
		@Column
		private Integer garden_decor_quantity;
		
		@Column
		private double totalamount;
		
		public UserCart() {
		
		}

		public UserCart(long cartid, long customerid, long plantid, Integer plant_quantity, long seedid,
				Integer seed_quantity, long fertilizerid, Integer fertlizer_quantity, long planterid,
				Integer planter_quantity, long gardendecorid, Integer garden_decor_quantity, double totalamount) {
			super();
			this.cartid = cartid;
			this.customerid = customerid;
			this.plantid = plantid;
			this.plant_quantity = plant_quantity;
			this.seedid = seedid;
			this.seed_quantity = seed_quantity;
			this.fertilizerid = fertilizerid;
			this.fertlizer_quantity = fertlizer_quantity;
			this.planterid = planterid;
			this.planter_quantity = planter_quantity;
			this.gardendecorid = gardendecorid;
			this.garden_decor_quantity = garden_decor_quantity;
			this.totalamount = totalamount;
		}

		public long getCartid() {
			return cartid;
		}

		public void setCartid(long cartid) {
			this.cartid = cartid;
		}

		public long getCustomerid() {
			return customerid;
		}

		public void setCustomerid(long customerid) {
			this.customerid = customerid;
		}

		public long getPlantid() {
			return plantid;
		}

		public void setPlantid(long plantid) {
			this.plantid = plantid;
		}

		public Integer getPlant_quantity() {
			return plant_quantity;
		}

		public void setPlant_quantity(Integer plant_quantity) {
			this.plant_quantity = plant_quantity;
		}

		public long getSeedid() {
			return seedid;
		}

		public void setSeedid(long seedid) {
			this.seedid = seedid;
		}

		public Integer getSeed_quantity() {
			return seed_quantity;
		}

		public void setSeed_quantity(Integer seed_quantity) {
			this.seed_quantity = seed_quantity;
		}

		public long getFertilizerid() {
			return fertilizerid;
		}

		public void setFertilizerid(long fertilizerid) {
			this.fertilizerid = fertilizerid;
		}

		public Integer getFertlizer_quantity() {
			return fertlizer_quantity;
		}

		public void setFertlizer_quantity(Integer fertlizer_quantity) {
			this.fertlizer_quantity = fertlizer_quantity;
		}

		public long getPlanterid() {
			return planterid;
		}

		public void setPlanterid(long planterid) {
			this.planterid = planterid;
		}

		public Integer getPlanter_quantity() {
			return planter_quantity;
		}

		public void setPlanter_quantity(Integer planter_quantity) {
			this.planter_quantity = planter_quantity;
		}

		public long getGardendecorid() {
			return gardendecorid;
		}

		public void setGardendecorid(long gardendecorid) {
			this.gardendecorid = gardendecorid;
		}

		public Integer getGarden_decor_quantity() {
			return garden_decor_quantity;
		}

		public void setGarden_decor_quantity(Integer garden_decor_quantity) {
			this.garden_decor_quantity = garden_decor_quantity;
		}

		public double getTotalamount() {
			return totalamount;
		}

		public void setTotalamount(double totalamount) {
			this.totalamount = totalamount;
		}

		@Override
		public String toString() {
			return "UserCart [cartid=" + cartid + ", customerid=" + customerid + ", plantid=" + plantid
					+ ", plant_quantity=" + plant_quantity + ", seedid=" + seedid + ", seed_quantity=" + seed_quantity
					+ ", fertilizerid=" + fertilizerid + ", fertlizer_quantity=" + fertlizer_quantity + ", planterid="
					+ planterid + ", planter_quantity=" + planter_quantity + ", gardendecorid=" + gardendecorid
					+ ", garden_decor_quantity=" + garden_decor_quantity + ", totalamount=" + totalamount + "]";
		}
}












