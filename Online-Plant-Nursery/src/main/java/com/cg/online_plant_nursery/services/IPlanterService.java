package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

public interface IPlanterService {
	public void addPlanter(Planter planter)throws DuplicateException ;
	public List<Planter> getAllPlanters()throws ListIsEmptyException;
	public void removePlanter(int PlanterId)throws IDNotFoundException;
	public void updatePlanter(int PlanterId, Planter planter)throws IDNotFoundException;
	public Planter getPlanterById(int PlanterId)throws IDNotFoundException;
	

}
