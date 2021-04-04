package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Plant;

public interface IPlantService {
	public void addPlant(Plant plant);
	public List<Plant> getAllPlants();
	public void removePlant(int PlantId);
	public void updatePlant(int PlantId, Plant plant);
	public Plant getPlantById(int PlantId);
	
}
