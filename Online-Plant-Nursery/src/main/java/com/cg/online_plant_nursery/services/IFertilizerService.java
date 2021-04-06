package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IFertilizerService {

	public void addFertilizer(long adminID,Fertilizer fertilizer)throws DuplicateException,NotAuthorizedException;
	public List<Fertilizer> getAllFertilizers()throws ListIsEmptyException;
	public void removeFertilizer(long adminID,int FertilizerId)throws IDNotFoundException,NotAuthorizedException;
	public void updateFertilizer(long adminID,int FertilizerId, Fertilizer fertilizer)throws IDNotFoundException,NotAuthorizedException;
	public Fertilizer getFertilizerById(int FertilizerId)throws IDNotFoundException;
}
