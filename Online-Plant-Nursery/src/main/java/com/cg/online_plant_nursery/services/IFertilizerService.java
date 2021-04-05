package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

public interface IFertilizerService {

	public void addFertilizer(Fertilizer fertilizer)throws DuplicateException ;
	public List<Fertilizer> getAllFertilizers()throws ListIsEmptyException;
	public void removeFertilizer(int FertilizerId)throws IDNotFoundException;
	public void updateFertilizer(int FertilizerId, Fertilizer fertilizer)throws IDNotFoundException;
	public Fertilizer getFertilizerById(int FertilizerId)throws IDNotFoundException;
}
