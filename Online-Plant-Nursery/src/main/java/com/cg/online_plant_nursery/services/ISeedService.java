package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface ISeedService {
	public void addSeed(Seed seed)throws DuplicateException;
	public List<Seed> getAllSeeds()throws ListIsEmptyException;
	public void removeSeed(int id) ;
	public void updateSeed(int id, Seed seed)throws IDNotFoundException;
	public Seed getSeedById(int SeedId)throws IDNotFoundException;
}
