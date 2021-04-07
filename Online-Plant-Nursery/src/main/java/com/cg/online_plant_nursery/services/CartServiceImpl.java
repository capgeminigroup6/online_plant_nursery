package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.FertilizerDAO;
import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.dao.PlanterDAO;
import com.cg.online_plant_nursery.dao.SeedDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;
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
	PlanterDAO planterDao;		//autowires these services with repository classes
	@Autowired
	FertilizerDAO fertilizerDao;
	@Autowired
	GardenDecorDAO gardenDecorDao;
	@Autowired
	AdminDAO admindao;
	
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
								for(Cart c1 : CartList) {
									if(c1.getCustomer().getId() == customerID && c1.getPlant().getId() == plantID) {
										c1.setPlant_quantity(quantity);
										c1.setTotalamount(c1.getTotalamount()+(quantity*pl.getPrice()));	//if cart has the product already with 0 quantity
										dao.save(c1);
										return;
									}
								}
								c2.setCustomer(c.getCustomer());
								c2.setPlant(pl);
								c2.setPlant_quantity(quantity);
								c2.setTotalamount(quantity*pl.getPrice());		//if a product of same category is already in the cart
								dao.save(c2);
								return;
							}
							c.setPlant(pl);
							c.setPlant_quantity(quantity);
							c.setTotalamount(c.getTotalamount()+(quantity*pl.getPrice()));	//if cart is empty
							dao.save(c);
							return;
					}
					throw new OutOfStockException();	//if product is not found in the list
				}
			}
			throw new IDNotFoundException();	//if customer id is not found in the list
	}
				

	@Override
	public void addSeedToCart(long customerID, long seedID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {
				if(seedDao.existsById (seedID)) {
					Seed s = seedDao.getSeedById(seedID);
					if(c.getSeed() != null) {
						Cart c2 = new Cart();
						for(Cart c1 : CartList) {
							if(c1.getCustomer().getId() == customerID && c1.getSeed().getId() == seedID) {
								c1.setSeed_quantity(quantity);
								c1.setTotalamount(c1.getTotalamount()+(quantity*s.getPrice()));	//if cart has the product already with 0 quantity
								dao.save(c1);
								return;
							}
						}
						c2.setCustomer(c.getCustomer());
						c2.setSeed(s);
						c2.setSeed_quantity(quantity);
						c2.setTotalamount(quantity*s.getPrice());	//if a product of same category is already in the cart
						dao.save(c2);
						return;
					}
						c.setSeed(s);
						c.setSeed_quantity(quantity);
						c.setTotalamount(c.getTotalamount()+(quantity*s.getPrice()));	//if cart is empty
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
					if(c.getPlanter() != null) {
						Cart c2 = new Cart();
						for(Cart c1 : CartList) {
							if(c1.getCustomer().getId() == customerID && c1.getPlanter().getId() == planterID) {
								c1.setPlanter_quantity(quantity);
								c1.setTotalamount(c1.getTotalamount()+(quantity*plr.getPrice()));	//if cart has the product already with 0 quantity
								dao.save(c1);
								return;
							}
						}
						c2.setCustomer(c.getCustomer());
						c2.setPlanter(plr);
						c2.setPlanter_quantity(quantity);
						c2.setTotalamount(quantity*plr.getPrice());
						dao.save(c2);	//if a product of same category is already in the cart
						return;
							
					}
						c.setPlanter(plr);
						c.setPlanter_quantity(quantity);
						c.setTotalamount(c.getTotalamount()+(quantity*plr.getPrice()));	//if cart is empty
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
					if(c.getGardendecor() != null) {
						Cart c2 = new Cart();
						for(Cart c1 : CartList) {
							if(c1.getCustomer().getId() == customerID && c1.getGardendecor().getId() == gardenDecorID) {
								c1.setGarden_decor_quantity(quantity);
								c1.setTotalamount(c1.getTotalamount()+(quantity*gd.getPrice()));	//if cart has the product already with 0 quantity
								dao.save(c1);
								return;
							}
						}
						c2.setCustomer(c.getCustomer());
						c2.setGardendecor(gd);
						c2.setGarden_decor_quantity(quantity);	//if a product of same category is already in the cart
						c2.setTotalamount(quantity*gd.getPrice());
						dao.save(c2);
						return;
							
					}
						c.setGardendecor(gd);
						c.setGarden_decor_quantity(quantity);
						c.setTotalamount(c.getTotalamount()+(quantity*gd.getPrice()));	//if cart is empty
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
					if(c.getFertilizer() != null) {
						Cart c2 = new Cart();
						for(Cart c1 : CartList) {
							if(c1.getCustomer().getId() == customerID && c1.getFertilizer().getId() == fertilizerID) {
								c1.setFertlizer_quantity(quantity);	
								c1.setTotalamount(c1.getTotalamount()+(quantity*fz.getPrice()));	//if cart has the product already with 0 quantity
								dao.save(c1);
								return;
							}
						}
						c2.setCustomer(c.getCustomer());
						c2.setFertilizer(fz);
						c2.setFertlizer_quantity(quantity);
						c2.setTotalamount(quantity*fz.getPrice());	//if a product of same category is already in the cart
						dao.save(c2);
						return;
							
					}
						c.setFertilizer(fz);
						c.setFertlizer_quantity(quantity);
						c.setTotalamount(c.getTotalamount()+(quantity*fz.getPrice()));	//if cart is empty
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
				c.setTotalamount(c.getTotalamount()-(plantDao.getPlantById(plantID).getPrice()*c.getPlant_quantity()));
				c.setPlant_quantity(0);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();	//if customer id not present
	}

	@Override
	public void removeSeedFromCart(long customerID, long seedID) throws IDNotFoundException {
		CartList = dao.findAll();
		
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID && c.getSeed().getId() == seedID) {
				
				c.setTotalamount(c.getTotalamount()-(seedDao.getSeedById(seedID).getPrice()*c.getSeed_quantity()));
				c.setSeed_quantity(0);
				dao.save(c);
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
				
				c.setTotalamount(c.getTotalamount()-(planterDao.getPlanterById(planterID).getPrice()*c.getPlanter_quantity()));
				c.setPlanter_quantity(0);
				dao.save(c);
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
				
				c.setTotalamount(c.getTotalamount()-(gardenDecorDao.getDecorById(gardenDecorID).getPrice()*c.getGarden_decor_quantity()));
				c.setGarden_decor_quantity(0);
				dao.save(c);
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
				
				c.setTotalamount(c.getTotalamount()-(fertilizerDao.getFertilizerById(fertilizerID).getPrice()*c.getFertlizer_quantity()));
				c.setFertlizer_quantity(0);
				dao.save(c);
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
				c.setTotalamount(c.getTotalamount()-(plantDao.getPlantById(plantID).getPrice()*c.getPlant_quantity()));//remove the price with the previous quantity
				c.setTotalamount(c.getTotalamount()+(plantDao.getPlantById(plantID).getPrice()*quantity));//update the price with new quantity
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
				c.setTotalamount(c.getTotalamount()-(seedDao.getSeedById(seedID).getPrice()*c.getSeed_quantity()));
				c.setTotalamount(c.getTotalamount()+(seedDao.getSeedById(seedID).getPrice()*quantity));
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
				c.setTotalamount(c.getTotalamount()-(planterDao.getPlanterById(planterID).getPrice()*c.getPlanter_quantity()));
				c.setTotalamount(c.getTotalamount()+(planterDao.getPlanterById(planterID).getPrice()*quantity));
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
				c.setTotalamount(c.getTotalamount()-(gardenDecorDao.getDecorById(gardenDecorID).getPrice()*c.getGarden_decor_quantity()));
				c.setTotalamount(c.getTotalamount()+(gardenDecorDao.getDecorById(gardenDecorID).getPrice()*quantity));
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
				c.setTotalamount(c.getTotalamount()-(fertilizerDao.getFertilizerById(fertilizerID).getPrice()*c.getFertlizer_quantity()));
				c.setTotalamount(c.getTotalamount()+(fertilizerDao.getFertilizerById(fertilizerID).getPrice()*quantity));
				c.setFertlizer_quantity(quantity);
				dao.save(c);
				return;
			}
		}
		throw new IDNotFoundException();		
	}

	@Override
	public List<Cart> viewCart(long adminID) throws ListIsEmptyException,NotAuthorizedException {
		if(admindao.existsById(adminID)) {
			if(dao.findAll().isEmpty()) {
				throw new ListIsEmptyException();	// if cart list is empty
			}
			return dao.findAll();
		}
		throw new NotAuthorizedException();		//only admin have access to this
		
	}


	@Override
	public Cart getOneCart(long customerID) throws IDNotFoundException {
		CartList = dao.findAll();
		for(Cart c : CartList) {
			if(c.getCustomer().getId() == customerID) {		//get particular customer's cart details
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
			if(c.getCustomer().getId() == customerID) {		//total cart amount of respective customer
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
