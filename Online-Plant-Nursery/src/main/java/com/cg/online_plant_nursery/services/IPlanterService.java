package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Planter;

public interface IPlanterService {
	public void addPlanter(Planter planter);
	public List<Planter> getAllPlanters();
	public void removePlanter(int PlanterId);
	public void updatePlanter(int PlanterId, Planter planter);
	public Planter getPlanterById(int PlanterId);

}
