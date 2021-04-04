package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.SeedDAO;
import com.cg.online_plant_nursery.entity.Seed;

@Service
public class SeedServiceImpl {
	@Autowired
	SeedDAO dao;
	public void addSeed(Seed seed) {
		dao.save(seed);
	}
	public List<Seed> getAllSeed(){
		List<Seed> seedList=dao.findAll();
		return seedList;
	}
	public Seed getSeedById(int SeedId) {
		return dao.getSeedById(SeedId);
	}
	
	public void removeSeed(int SeedId) {
		if(dao.existsById(SeedId)) {
			dao.deleteById(SeedId);
		}

	}
	public void updateSeed(int SeedId,Seed seed) {
		if(dao.existsById(SeedId)) {
			Seed seed1=dao.findById(SeedId).get();
			seed1.setName(seed.getName());
			seed1.setId(seed.getId());
			seed1.setPrice(seed.getPrice());
			seed1.setSeedsPerPacket(seed.getSeedsPerPacket());
			seed1.setDescription(seed.getDescription());
			seed1.setImage(seed.getImage());
			dao.save(seed);
		}
	
	}
}
