package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface ISeedService {
	public void addSeed(long adminID,Seed seed)throws DuplicateException,NotAuthorizedException ;
	public List<Seed> getAllSeeds()throws ListIsEmptyException;
	public void removeSeed(long adminID,int SeedId)throws IDNotFoundException,NotAuthorizedException ;
	public void updateSeed(long adminID,int SeedId, Seed seed)throws IDNotFoundException,NotAuthorizedException ;
	public Seed getSeedById(int SeedId)throws IDNotFoundException;
}
