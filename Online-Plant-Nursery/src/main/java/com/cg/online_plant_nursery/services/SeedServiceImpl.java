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
	public void addSeed(long adminID,Seed seed) throws DuplicateException,NotAuthorizedException  {
		seedList = dao.findAll();
		if(admindao.existsById(adminID)) {
			for(Seed sd: seedList) {
				if(sd.getId() ==seed.getId()){
					throw new DuplicateException();
				}
			}
			dao.save(seed);
			return;
		}
		throw new NotAuthorizedException();
			}
	
	@Override
	public List<Seed> getAllSeeds() throws ListIsEmptyException {
		 seedList=dao.findAll();
		 if(seedList.isEmpty()) {
				throw new ListIsEmptyException();
			}
			return seedList;
	}
	@Override
	public void removeSeed(long adminID,int Id) throws IDNotFoundException,NotAuthorizedException {
		seedList = dao.findAll();
		if(admindao.existsById(adminID)) {
			for(Seed sd: seedList) {
				if(sd.getId()==Id) {
					 dao.deleteById((long) Id);
					 return;
				}
			}
			throw new IDNotFoundException();
		}
		throw new NotAuthorizedException();
			 		}
		@Override
	public void updateSeed(long adminID,int Id, Seed seed)  throws IDNotFoundException,NotAuthorizedException {
		seedList = dao.findAll();
		if(admindao.existsById(adminID)) {
			for(Seed sd: seedList) {
				if(sd.getId()==Id) {
					Seed seed1=dao.getSeedById(Id);
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
		throw new NotAuthorizedException();
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

