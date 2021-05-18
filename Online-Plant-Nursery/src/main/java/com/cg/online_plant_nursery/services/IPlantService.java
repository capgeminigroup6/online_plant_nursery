package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IPlantService {
	
	public List<Plant> getAllPlants()throws ListIsEmptyException;
	public void deletePlant(int plantId)throws IDNotFoundException;
	public void updatePlant(int id, Plant plant);
	public Plant getPlantById(int plantId)throws IDNotFoundException;
	public void addPlant(Plant plant) throws DuplicateException;
	

}
