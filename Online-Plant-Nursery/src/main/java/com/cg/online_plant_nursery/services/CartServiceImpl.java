package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.OutOfStockException;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartDAO dao;
	@Autowired
	CustomerDAO custDao;
	@Autowired
	PlantDAO plantDao;
	
	List<Cart> CartList = new ArrayList<>();
	List<Customer> customerList = new ArrayList<>();
	List<Plant> plantList = new ArrayList<>();
	
	@Override
	public void addPlantToCart(long customerID, long plantID, int quantity) throws IDNotFoundException,OutOfStockException {
		CartList = dao.findAll();
		customerList = custDao.findAll();
		
		for(Customer customer : customerList) {
			if(customer.getId() == customerID) {
				plantList = plantDao.findAll();
				for(Plant p : plantList) {
					if(p.getId() == plantID) {
						List<Plant> plantList1 = new ArrayList<>();
						for(Cart c : CartList) {
							if(c.getCustomer().getId() == customerID) {
								plantList1 = c.getPlantList();
								for(int i=0; i<quantity; i++) {
									plantList1.add(p);
								}
								c.setPlantList(plantList1);
								c.setTotalAmount(quantity*p.getPrice());
								dao.save(c);
								return;
							}
						}
//						for(int i=0; i<quantity; i++) {
//							plantList1.add(p);
//						}
//						Cart c = new Cart();
//						c.setCustomer(customer);
//						c.setPlantList(plantList1);
//						c.setTotalAmount(quantity*p.getPrice());
//						dao.save(c);
//						return;
					}
				}
				throw new OutOfStockException();
			}
		}
		throw new IDNotFoundException();
	}

	@Override
	public void addSeedToCart(long customerID, long seedID, int quantity) throws IDNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlanterToCart(long customerID, long planterID, int quantity) throws IDNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGardenDecorToCart(long customerID, long gardenDecorID, int quantity) throws IDNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFertilizerToCart(long customerID, long fertilizerID, int quantity) throws IDNotFoundException {
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
	public void updateGardenDecorQuantity(long customerID, long gardenDecorID, int quantity)
			throws IDNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFertilizerQuantity(long customerID, long fertilizerID, int quantity) throws IDNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cart> viewCart() throws ListIsEmptyException {
		// TODO Auto-generated method stub
		return null;
	}
}
