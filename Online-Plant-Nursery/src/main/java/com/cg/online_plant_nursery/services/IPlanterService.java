package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Planter;

public interface IPlanterService {
	public Planter addPlanter(Planter planter);
	public List<Planter> getAllPlanters();
	public Planter removePlanter(int PlanterId);
	public Planter updatePlanter(int PlanterId, Planter planter);
	public Planter getPlanterById(int PlanterId);
}
