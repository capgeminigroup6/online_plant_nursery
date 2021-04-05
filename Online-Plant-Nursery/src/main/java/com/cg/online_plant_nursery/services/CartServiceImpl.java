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
//	@Autowired
//	PlantDAO plantDao;
//	@Autowired
//	SeedDAO seedDao;
//	@Autowired
//	PlanterDAO planterDao;
//	@Autowired
//	FertilizerDAO fertilizerDao;
//	@Autowired
//	GardenDecorDAO gardenDecorDao;
//	
//	List<Cart> CartList = new ArrayList<>();	
//	@Override
//	public void addPlantToCart(long customerID, long plantID, int quantity) throws IDNotFoundException,OutOfStockException {
//		CartList = dao.findAll();
//		
//			for(Cart c : CartList) {
//				if(c.getCustomer().getId() == customerID) {
//					if(plantDao.existsById((int) plantID)) {
//						Plant pl = plantDao.getPlantById(plantID);
//							c.setPlantid(plantID);
//							c.setPlant_quantity(quantity);
//							c.setTotalamount(quantity*pl.getPrice());
//							dao.save(c);
//							return;
//					}
//					throw new OutOfStockException();
//				}
//			}
//			throw new IDNotFoundException();
//	}
//				
//
//	@Override
//	public void addSeedToCart(long customerID, long seedID, int quantity) throws IDNotFoundException,OutOfStockException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID) {
//				if(seedDao.existsById((int) seedID)) {
//					Seed s = seedDao.getSeedById(seedID);
//						c.setSeedid(seedID);
//						c.setSeed_quantity(quantity);
//						c.setTotalamount(quantity*s.getPrice());
//						dao.save(c);
//						return;
//				}
//				throw new OutOfStockException();
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void addPlanterToCart(long customerID, long planterID, int quantity) throws IDNotFoundException,OutOfStockException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID) {
//				if(planterDao.existsById((int) planterID)) {
//					Planter plr = planterDao.getPlanterById(planterID);
//						c.setPlanterid(planterID);
//						c.setPlanter_quantity(quantity);
//						c.setTotalamount(quantity*plr.getPrice());
//						dao.save(c);
//						return;
//				}
//				throw new OutOfStockException();
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void addGardenDecorToCart(long customerID, long gardenDecorID, int quantity) throws IDNotFoundException,OutOfStockException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID) {
//				if(gardenDecorDao.existsById((int) gardenDecorID)) {
//					GardenDecor gd = gardenDecorDao.getDecorById(gardenDecorID);
//						c.setGardendecorid(gardenDecorID);
//						c.setGarden_decor_quantity(quantity);
//						c.setTotalamount(quantity*gd.getPrice());
//						dao.save(c);
//						return;
//				}
//				throw new OutOfStockException();
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void addFertilizerToCart(long customerID, long fertilizerID, int quantity) throws IDNotFoundException,OutOfStockException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID) {
//				if(fertilizerDao.existsById((int)fertilizerID)) {
//					Fertilizer fz = fertilizerDao.getFertilizerById(fertilizerID);
//						c.setFertilizerid(fertilizerID);
//						c.setFertlizer_quantity(quantity);
//						c.setTotalamount(quantity*fz.getPrice());
//						dao.save(c);
//						return;
//				}
//				throw new OutOfStockException();
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void removePlantFromCart(long customerID, long plantID) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getPlantid() == plantID) {
//				dao.delete(c);
//			}
//		}
//		throw new IDNotFoundException();
//	}
//
//	@Override
//	public void removeSeedFromCart(long customerID, long seedID) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getSeedid() == seedID) {
//				dao.delete(c);
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void removePlanterFromCart(long customerID, long planterID) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getPlanterid() == planterID) {
//				dao.delete(c);
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void removeGardenDecorFromCart(long customerID, long gardenDecorID) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getGardendecorid() == gardenDecorID) {
//				dao.delete(c);
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void removeFertilizerFromCart(long customerID, long fertilizerID) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getFertilizerid() == fertilizerID) {
//				dao.delete(c);
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void updatePlantQuantity(long customerID, long plantID, int quantity) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {	
//			if(c.getCustomer().getId() == customerID && c.getPlantid() == plantID) {
//				c.setPlant_quantity(quantity);
//				dao.save(c);
//			}
//		}
//	}
//
//	@Override
//	public void updateSeedQuantity(long customerID, long seedID, int quantity) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getSeedid() == seedID) {
//				c.setSeed_quantity(quantity);
//				dao.save(c);
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
//	@Override
//	public void updatePlanterQuantity(long customerID, long planterID, int quantity) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getPlanterid() == planterID) {
//				c.setPlanter_quantity(quantity);
//				dao.save(c);
//			}
//		}
//		throw new IDNotFoundException();			
//	}
//
//	@Override
//	public void updateGardenDecorQuantity(long customerID, long gardenDecorID, int quantity)throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getGardendecorid() == gardenDecorID) {
//				c.setGarden_decor_quantity(quantity);
//				dao.save(c);
//			}
//		}
//		throw new IDNotFoundException();			
//	}
//
//	@Override
//	public void updateFertilizerQuantity(long customerID, long fertilizerID, int quantity) throws IDNotFoundException {
//		CartList = dao.findAll();
//		
//		for(Cart c : CartList) {
//			if(c.getCustomer().getId() == customerID && c.getFertilizerid() == fertilizerID) {
//				c.setFertlizer_quantity(quantity);
//				dao.save(c);
//			}
//		}
//		throw new IDNotFoundException();		
//	}
//
	@Override
	public List<Cart> viewCart() throws ListIsEmptyException {
		return dao.findAll();
	}
@Override
public void addPlantToCart(long customerID, long plantID, int quantity)
		throws IDNotFoundException, OutOfStockException {
	// TODO Auto-generated method stub
	
}
@Override
public void addSeedToCart(long customerID, long seedID, int quantity) throws IDNotFoundException, OutOfStockException {
	// TODO Auto-generated method stub
	
}
@Override
public void addPlanterToCart(long customerID, long planterID, int quantity)
		throws IDNotFoundException, OutOfStockException {
	// TODO Auto-generated method stub
	
}
@Override
public void addGardenDecorToCart(long customerID, long gardenDecorID, int quantity)
		throws IDNotFoundException, OutOfStockException {
	// TODO Auto-generated method stub
	
}
@Override
public void addFertilizerToCart(long customerID, long fertilizerID, int quantity)
		throws IDNotFoundException, OutOfStockException {
	// TODO Auto-generated method stub
	
}
@Override
public void removePlantFromCart(long customerID, long plantID) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void removeSeedFromCart(long customerID, long seedID) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void removePlanterFromCart(long customerID, long planterID) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void removeGardenDecorFromCart(long customerID, long gardenDecorID) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void removeFertilizerFromCart(long customerID, long fertilizerID) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void updatePlantQuantity(long customerID, long plantID, int quantity) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void updateSeedQuantity(long customerID, long seedID, int quantity) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void updatePlanterQuantity(long customerID, long planterID, int quantity) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void updateGardenDecorQuantity(long customerID, long gardenDecorID, int quantity) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
@Override
public void updateFertilizerQuantity(long customerID, long fertilizerID, int quantity) throws IDNotFoundException {
	// TODO Auto-generated method stub
	
}
}
