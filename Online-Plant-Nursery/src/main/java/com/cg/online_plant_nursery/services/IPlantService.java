package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IPlantService {
	public void addPlant(long adminID,Plant plant) throws DuplicateException,NotAuthorizedException ;
	public List<Plant> getAllPlants()throws ListIsEmptyException;
	public void removePlant(long adminID,int plantId)throws IDNotFoundException,NotAuthorizedException;
	public void updatePlant(long adminID,int plantId, Plant plant)throws IDNotFoundException,NotAuthorizedException;
	public Plant getPlantById(int plantId)throws IDNotFoundException;

}
