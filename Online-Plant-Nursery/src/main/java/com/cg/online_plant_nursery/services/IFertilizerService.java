package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Fertilizer;

public interface IFertilizerService {


	public void addFertilizer(Fertilizer fertilizer);
	public List<Fertilizer> getAllFertilizers();
	public void removeFertilizer(int FertilizerId);
	public void updateFertilizer(int FertilizerId, Fertilizer fertilizer);
	public Fertilizer getFertilizerById(int FertilizerId);
}
