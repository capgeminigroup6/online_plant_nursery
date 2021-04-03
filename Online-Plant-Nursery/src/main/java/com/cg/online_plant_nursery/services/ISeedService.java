package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Seed;

public interface ISeedService {
	public Seed addSeed(Seed seed);
	public List<Seed> getAllSeeds();
	public Seed removeSeed(int SeedId);
	public Seed updateSeed(int SeedId, Seed seed);
	public Seed getSeedById(int SeedId);
}
