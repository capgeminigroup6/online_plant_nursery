package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.entity.Cart;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartDAO dao;
	
	@Override
	public void addPlantToCart(long customerID, long plantID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSeedToCart(long customerID, long seedID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlanterToCart(long customerID, long planterID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGardenDecorToCart(long customerID, long gardenDecorID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFertilizerToCart(long customerID, long fertilizerID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlantFromCart(long customerID, long plantID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSeedFromCart(long customerID, long seedID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlanterFromCart(long customerID, long planterID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGardenDecorFromCart(long customerID, long gardenDecorID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFertilizerFromCart(long customerID, long fertilizerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlantQuantity(long customerID, long plantID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSeedQuantity(long customerID, long seedID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlanterQuantity(long customerID, long planterID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGardenDecorQuantity(long customerID, long gardenDecorID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFertilizerQuantity(long customerID, long fertilizerID, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cart> viewCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
