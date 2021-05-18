package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IPlanterService {
	public void addPlanter(Planter planter)throws DuplicateException;
	public List<Planter> getAllPlanters()throws ListIsEmptyException;
	public void deletePlanter(int planterId)throws IDNotFoundException;
	public void updatePlanter(int id, Planter planter);
	public Planter getPlanterById(int planterId)throws IDNotFoundException;
}
