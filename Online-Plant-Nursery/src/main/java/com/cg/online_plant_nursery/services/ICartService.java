package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;
import com.cg.online_plant_nursery.utils.OutOfStockException;

public interface ICartService {
	public void addPlantToCart(long customerID,long plantID, int quantity) throws IDNotFoundException,OutOfStockException;
	public void addSeedToCart(long customerID,long seedID, int quantity) throws IDNotFoundException,OutOfStockException;
	public void addPlanterToCart(long customerID,long planterID, int quantity) throws IDNotFoundException,OutOfStockException;
	public void addGardenDecorToCart(long customerID,long gardenDecorID, int quantity) throws IDNotFoundException,OutOfStockException;
	public void addFertilizerToCart(long customerID,long fertilizerID, int quantity) throws IDNotFoundException,OutOfStockException;
	
	public void removePlantFromCart(long customerID,long plantID) throws IDNotFoundException;
	public void removeSeedFromCart(long customerID,long seedID) throws IDNotFoundException;
	public void removePlanterFromCart(long customerID,long planterID) throws IDNotFoundException;
	public void removeGardenDecorFromCart(long customerID,long gardenDecorID) throws IDNotFoundException;
	public void removeFertilizerFromCart(long customerID,long fertilizerID) throws IDNotFoundException;
	
	public void updatePlantQuantity(long customerID,long plantID, int quantity) throws IDNotFoundException;
	public void updateSeedQuantity(long customerID,long seedID, int quantity) throws IDNotFoundException;
	public void updatePlanterQuantity(long customerID,long planterID, int quantity) throws IDNotFoundException;
	public void updateGardenDecorQuantity(long customerID,long gardenDecorID, int quantity) throws IDNotFoundException;
	public void updateFertilizerQuantity(long customerID,long fertilizerID, int quantity) throws IDNotFoundException;
	
	public Cart getOneCart(long customerID) throws IDNotFoundException;
	public List<Cart> viewCart(long adminID) throws ListIsEmptyException,NotAuthorizedException;
	
	public double TotalCartAmount(long customerID) throws IDNotFoundException;
}
