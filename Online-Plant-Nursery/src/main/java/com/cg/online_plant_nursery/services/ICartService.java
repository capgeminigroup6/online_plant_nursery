package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.utils.IDNotFoundException;

public interface ICartService {
	public void addPlantToCart(long customerID,long plantID, int quantity) throws IDNotFoundException;
	public void addSeedToCart(long customerID,long seedID, int quantity) throws IDNotFoundException;
	public void addPlanterToCart(long customerID,long planterID, int quantity) throws IDNotFoundException;
	public void addGardenDecorToCart(long customerID,long gardenDecorID, int quantity) throws IDNotFoundException;
	public void addFertilizerToCart(long customerID,long fertilizerID, int quantity) throws IDNotFoundException;
	
	public void removePlantFromCart(long customerID,long plantID);
	public void removeSeedFromCart(long customerID,long seedID);
	public void removePlanterFromCart(long customerID,long planterID);
	public void removeGardenDecorFromCart(long customerID,long gardenDecorID);
	public void removeFertilizerFromCart(long customerID,long fertilizerID);
	
	public void updatePlantQuantity(long customerID,long plantID, int quantity);
	public void updateSeedQuantity(long customerID,long seedID, int quantity);
	public void updatePlanterQuantity(long customerID,long planterID, int quantity);
	public void updateGardenDecorQuantity(long customerID,long gardenDecorID, int quantity);
	public void updateFertilizerQuantity(long customerID,long fertilizerID, int quantity);
	
	public List<Cart> viewCart();
}
