package com.cg.online_plant_nursery.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid",referencedColumnName = "id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plantid",referencedColumnName = "id")
	private Plant plant;
	@Column
	private Integer plant_quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seedid",referencedColumnName = "id")
	private Seed seed;
	@Column
	private Integer seed_quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fertilizerid",referencedColumnName = "id")
	private Fertilizer fertilizer;
	@Column
	private Integer fertlizer_quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planterid",referencedColumnName = "id")
	private Planter planter;
	@Column
	private Integer planter_quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gardendecorid",referencedColumnName = "id")
	private GardenDecor gardendecor;
	@Column
	private Integer garden_decor_quantity;
	
	@Column
	private double totalamount;
	
	public Cart() {
	}

	public Cart(long cartid, Customer customer, Plant plant, Integer plant_quantity, Seed seed, Integer seed_quantity,
			Fertilizer fertilizer, Integer fertlizer_quantity, Planter planter, Integer planter_quantity,
			GardenDecor gardendecor, Integer garden_decor_quantity, double totalamount) {
		super();
		this.cartid = cartid;
		this.customer = customer;
		this.plant = plant;
		this.plant_quantity = plant_quantity;
		this.seed = seed;
		this.seed_quantity = seed_quantity;
		this.fertilizer = fertilizer;
		this.fertlizer_quantity = fertlizer_quantity;
		this.planter = planter;
		this.planter_quantity = planter_quantity;
		this.gardendecor = gardendecor;
		this.garden_decor_quantity = garden_decor_quantity;
		this.totalamount = totalamount;
	}

	public long getCartid() {
		return cartid;
	}

	public void setCartid(long cartid) {
		this.cartid = cartid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Integer getPlant_quantity() {
		return plant_quantity;
	}

	public void setPlant_quantity(Integer plant_quantity) {
		this.plant_quantity = plant_quantity;
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}

	public Integer getSeed_quantity() {
		return seed_quantity;
	}

	public void setSeed_quantity(Integer seed_quantity) {
		this.seed_quantity = seed_quantity;
	}

	public Fertilizer getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(Fertilizer fertilizer) {
		this.fertilizer = fertilizer;
	}

	public Integer getFertlizer_quantity() {
		return fertlizer_quantity;
	}

	public void setFertlizer_quantity(Integer fertlizer_quantity) {
		this.fertlizer_quantity = fertlizer_quantity;
	}

	public Planter getPlanter() {
		return planter;
	}

	public void setPlanter(Planter planter) {
		this.planter = planter;
	}

	public Integer getPlanter_quantity() {
		return planter_quantity;
	}

	public void setPlanter_quantity(Integer planter_quantity) {
		this.planter_quantity = planter_quantity;
	}

	public GardenDecor getGardendecor() {
		return gardendecor;
	}

	public void setGardendecor(GardenDecor gardendecor) {
		this.gardendecor = gardendecor;
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
		return "Cart [cartid=" + cartid + ", customer=" + customer + ", plant=" + plant + ", plant_quantity="
				+ plant_quantity + ", seed=" + seed + ", seed_quantity=" + seed_quantity + ", fertilizer=" + fertilizer
				+ ", fertlizer_quantity=" + fertlizer_quantity + ", planter=" + planter + ", planter_quantity="
				+ planter_quantity + ", gardendecor=" + gardendecor + ", garden_decor_quantity=" + garden_decor_quantity
				+ ", totalamount=" + totalamount + "]";
	}

	
	
}
