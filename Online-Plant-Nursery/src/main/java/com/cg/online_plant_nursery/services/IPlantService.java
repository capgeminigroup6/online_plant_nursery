package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

public interface IPlantService {
	public void addPlant(Plant plant) throws DuplicateException ;
	public List<Plant> getAllPlants()throws ListIsEmptyException;
	public void removePlant(int PlantId)throws IDNotFoundException;
	public void updatePlant(int PlantId, Plant plant)throws IDNotFoundException;
	public Plant getPlantById(int PlantId)throws IDNotFoundException;

}
