package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IPlanterService {
	public void addPlanter(long adminID,Planter planter)throws DuplicateException,NotAuthorizedException;
	public List<Planter> getAllPlanters()throws ListIsEmptyException;
	public void removePlanter(long adminID,int planterId)throws IDNotFoundException,NotAuthorizedException;
	public void updatePlanter(long adminID,int planterId, Planter planter)throws IDNotFoundException, NotAuthorizedException;
	public Planter getPlanterById(int planterId)throws IDNotFoundException;
}

