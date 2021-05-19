package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IGardenDecorService {
	public void addDecor(GardenDecor decor)throws DuplicateException;
	public List<GardenDecor> getAllDecors()throws ListIsEmptyException;
	public void removeDecor(int DecorId);
	public void updateGardenDecor(int DecorId, GardenDecor decor)throws IDNotFoundException;
	public GardenDecor getDecorById(int DecorId)throws IDNotFoundException;
}
