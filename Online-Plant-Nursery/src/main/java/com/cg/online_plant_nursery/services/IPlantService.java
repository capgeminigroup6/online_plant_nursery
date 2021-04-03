package com.cg.online_plant_nursery.services;

public interface IPlantService {
	public Plant addPlant(Plant plant);
	public List<Plant> getAllPlants();
	public Plant removePlant(int PlantId);
	public Plant updatePlant(int PlantId, Plant plant);
	public Plant getPlantById(int PlantId);
	
}
