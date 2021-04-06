package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IGardenDecorService {
	public void addDecor(long adminID,GardenDecor decor)throws DuplicateException,NotAuthorizedException;
	public List<GardenDecor> getAllDecors()throws ListIsEmptyException;
	public void removeDecor(long adminID,int DecorId)throws IDNotFoundException,NotAuthorizedException;
	public void updateGardenDecor(long adminID,int DecorId, GardenDecor decor)throws IDNotFoundException,NotAuthorizedException;
	public GardenDecor getDecorById(int DecorId)throws IDNotFoundException;
}
