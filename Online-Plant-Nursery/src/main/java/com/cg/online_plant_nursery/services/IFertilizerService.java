package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Fertilizer;

public interface IFertilizerService {

	public void addFertilizer(Fertilizer fertilizer)throws DuplicateException ;;
	public List<Fertilizer> getAllFertilizers()throws ListIsEmptyException;;
	public void removeFertilizer(int FertilizerId)throws IDNotFoundException;;
	public void updateFertilizer(int FertilizerId, Fertilizer fertilizer)throws IDNotFoundException;;
	public Fertilizer getFertilizerById(int FertilizerId)throws IDNotFoundException;;
}
