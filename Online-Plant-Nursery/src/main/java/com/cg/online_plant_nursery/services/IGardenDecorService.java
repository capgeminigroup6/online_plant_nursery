package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.GardenDecor;

public interface IGardenDecorService {
	public GardenDecor addDecor(GardenDecor decor);
	public List<GardenDecor> getAllDecors();
	public GardenDecor removeDecor(int DecorId);
	public GardenDecor updateDecor(int DecorId, GardenDecor decor);
	public GardenDecor getDecorById(int DecorId);
}
