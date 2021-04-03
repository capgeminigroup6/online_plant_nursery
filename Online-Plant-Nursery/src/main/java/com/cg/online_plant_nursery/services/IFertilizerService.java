package com.cg.online_plant_nursery.services;

public interface IFertilizerService {

	public Fertilizer addFertilizer(Fertilizer fertilizer);
	public List<Fertilizer> getAllFertilizers();
	public Fertilizer removeFertilizer(int FertilizerId);
	public Fertilizer updateFertilizer(int FertilizerId, Fertilizer fertilizer);
	public Fertilizer getFertilizerById(int FertilizerId);
	
}
