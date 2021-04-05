package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

public interface ISeedService {
	public void addSeed(Seed seed)throws DuplicateException ;
	public List<Seed> getAllSeeds()throws ListIsEmptyException;
	public void removeSeed(int SeedId)throws IDNotFoundException;
	public void updateSeed(int SeedId, Seed seed)throws IDNotFoundException;
	public Seed getSeedById(int SeedId)throws IDNotFoundException;
}
