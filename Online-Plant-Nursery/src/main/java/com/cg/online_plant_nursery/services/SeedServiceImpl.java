package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.SeedDAO;
import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service
public class SeedServiceImpl implements ISeedService {
	@Autowired
	SeedDAO dao;
	@Autowired
	AdminDAO admindao;
	
	List<Seed> seedList = new ArrayList<>();
	@Override
	public void addSeed(Seed seed) throws DuplicateException {
		seedList = dao.findAll();

			for(Seed sd: seedList) {
				if(sd.getId() ==seed.getId()){
					throw new DuplicateException();
				}
			}
			dao.save(seed);
			return;
		}
		
	
	@Override
	public List<Seed> getAllSeeds() throws ListIsEmptyException {
		 seedList=dao.findAll();
		 if(seedList == null) {
				throw new ListIsEmptyException();
			}
			return seedList;
	}
	@Override
	public void removeSeed(int Id)  {
		seedList = dao.findAll();
		
			for(Seed sd: seedList) {
				if(sd.getId()==Id) {
					 dao.deleteById((long) Id);
					 return;
				}
			}
		}
		
		@Override
	public void updateSeed(int id, Seed seed)  throws IDNotFoundException {
		seedList = dao.findAll();

			for(Seed sd: seedList) {
				if(sd.getId()==id) {
					Seed seed1=dao.findById((long) id).get();
				      seed1.setId(seed.getId());
				      seed1.setName(seed.getName());
				      seed1.setSeedsperpacket(seed.getSeedsperpacket());
				      seed1.setPrice(seed.getPrice());
				      seed1.setDescription(seed.getDescription());
				      seed1.setImage(seed.getImage());
				      dao.save(seed1);
				      return;
						}
			}
			 throw new IDNotFoundException();
		}
	
		
		@Override
	public Seed getSeedById(int Id) throws IDNotFoundException {
		seedList = dao.findAll();
		for(Seed sd: seedList) {
			if(sd.getId()== Id) {
				return sd;
			}
		}
		throw new IDNotFoundException();
	}
}

