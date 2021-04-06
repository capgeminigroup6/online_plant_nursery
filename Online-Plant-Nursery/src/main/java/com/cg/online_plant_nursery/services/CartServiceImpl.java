package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.dao.FertilizerDAO;
import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.dao.PlanterDAO;
import com.cg.online_plant_nursery.dao.SeedDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.OutOfStockException;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartDAO dao;
	@Autowired
	PlantDAO plantDao;
	@Autowired
	SeedDAO seedDao;
	@Autowired
	PlanterDAO planterDao;
	@Autowired
	FertilizerDAO fertilizerDao;
	@Autowired
	GardenDecorDAO gardenDecorDao;
	
	List<Cart> CartList = new ArrayList<>();	
	@Override
	public void addPlantToCart(long customerID, long plantID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		
			for(Cart c : CartList) {
				if(c.getCustomer().getId() == customerID) {
					if(plantDao.existsById(plantID)) {
						Plant pl = plantDao.getPlantById(plantID);
							if(c.getPlant() != null) {
								Cart c2 = new Cart();
								//c2.setCartid(c.getCartid());
								c2.setCustomer(c.getCustomer());
								c2.setPlant(pl);
								c2.setPlant_quantity(quantity);
								c2.setTotalamount(quantity*pl.getPrice());
								dao.save(c2);
								return;
									
							}
							c.setPlant(pl);
							c.setPlant_quantity(quantity);
							c.setTotalamount(quantity*pl.getPrice());
							dao.save(c);
							return;
					}
					throw new OutOfStockException();
				}
			}
			throw new IDNotFoundException();
	}
				

	@Override
	public void addSeedToCart(long customerID, long seedID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				if(seedDao.existsById (seedID)) {
					Seed s = seedDao.getSeedById(seedID);
						c.setSeed(s);
						c.setSeed_quantity(quantity);
						c.setTotalamount(quantity*s.getPrice());
						dao.save(c);
						return;
				}
				throw new OutOfStockException();
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void addPlanterToCart(long customerID, long planterID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				if(planterDao.existsById( planterID)) {
					Planter plr = planterDao.getPlanterById(planterID);
						c.setPlanter(plr);
						c.setPlanter_quantity(quantity);
						c.setTotalamount(quantity*plr.getPrice());
						dao.save(c);
						return;
				}
				throw new OutOfStockException();
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void addGardenDecorToCart(long customerID, long gardenDecorID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				if(gardenDecorDao.existsById( gardenDecorID)) {
					GardenDecor gd = gardenDecorDao.getDecorById(gardenDecorID);
						c.setGardendecor(gd);
						c.setGarden_decor_quantity(quantity);
						c.setTotalamount(quantity*gd.getPrice());
						dao.save(c);
						return;
				}
				throw new OutOfStockException();
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void addFertilizerToCart(long customerID, long fertilizerID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				if(fertilizerDao.existsById(fertilizerID)) {
					Fertilizer fz = fertilizerDao.getFertilizerById(fertilizerID);
						c.setFertilizer(fz);
						c.setFertlizer_quantity(quantity);
						c.setTotalamount(quantity*fz.getPrice());
						dao.save(c);
						return;
				}
				throw new OutOfStockException();
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removePlantFromCart(long customerID, long plantID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlant().getId() == plantID) {
				//dao.delete(c);
				c.setPlant(null);
				c.setPlant_quantity(null);
				c.setTotalamount(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();
	}

	@Override
	public void removeSeedFromCart(long customerID, long seedID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getSeed().getId() == seedID) {
				dao.delete(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removePlanterFromCart(long customerID, long planterID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlanter().getId() == planterID) {
				dao.delete(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removeGardenDecorFromCart(long customerID, long gardenDecorID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getGardendecor().getId() == gardenDecorID) {
				dao.delete(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void removeFertilizerFromCart(long customerID, long fertilizerID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getFertilizer().getId() == fertilizerID) {
				dao.delete(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void updatePlantQuantity(long customerID, long plantID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {	
			if(c.getCustomer().getId() == customerID && c.getPlant().getId() == plantID) {
				Plant pl = plantDao.getPlantById(plantID);
				c.setTotalamount(quantity*pl.getPrice());
				c.setPlant_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();
	}

	@Override
	public void updateSeedQuantity(long customerID, long seedID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getSeed().getId() == seedID) {
				Seed sd = seedDao.getSeedById(seedID);
				c.setTotalamount(quantity*sd.getPrice());
				c.setSeed_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public void updatePlanterQuantity(long customerID, long planterID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getPlanter().getId() == planterID) {
				Planter plr = planterDao.getPlanterById(planterID);
				c.setTotalamount(quantity*plr.getPrice());
				c.setPlanter_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();			
	}

	@Override
	public void updateGardenDecorQuantity(long customerID, long gardenDecorID, int quantity)throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getGardendecor().getId() == gardenDecorID) {
				GardenDecor gd = gardenDecorDao.getDecorById(gardenDecorID);
				c.setTotalamount(quantity*gd.getPrice());
				c.setGarden_decor_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();			
	}

	@Override
	public void updateFertilizerQuantity(long customerID, long fertilizerID, int quantity) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getFertilizer().getId() == fertilizerID) {
				Fertilizer fz = fertilizerDao.getFertilizerById(fertilizerID);
				c.setTotalamount(quantity*fz.getPrice());
				c.setFertlizer_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public List<Cart> viewCart() throws ListIsEmptyException {
		if(dao.findAll().isEmpty()) {
			throw new ListIsEmptyException();
		}
		return dao.findAll();
	}


	@Override
	public Cart getOneCart(long customerID) throws IDNotFoundException {
		CartList = dao.findAll();
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				return c;
			}
		}
		throw new IDNotFoundException();
	}


	@Override
	public double TotalCartAmount(long customerID) throws IDNotFoundException {
		double amt = 0;
		CartList = dao.findAll();
		boolean flag = false;
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				flag= true;
				amt+=c.getTotalamount();
			}
		}
		if(flag == false) {
			throw new IDNotFoundException();
		}
		return amt;
	}

}
