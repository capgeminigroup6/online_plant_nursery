package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.entity.GardenDecor;

@Service
public class GardenDecorServiceImpl implements IGardenDecorService{
	@Autowired
  GardenDecorDAO dao;

	@Override
	public void addDecor(GardenDecor decor) {
		dao.save(decor);
		
	}

	@Override
	public List<GardenDecor> getAllDecors() {
		List<GardenDecor> decorList=dao.findAll();
		return decorList;
	}

	@Override
	public void removeDecor(int DecorId) {
		if(dao.existsById(DecorId)) {
			dao.deleteById(DecorId);
		}
		
	}

	@Override
	public void updateDecor(int DecorId, GardenDecor decor) {
		if(dao.existsById(DecorId)) {
			GardenDecor decor1=dao.findById(DecorId).get();
			decor1.setId(decor.getId());
	    	decor1.setName(decor.getName());
	    	
	    	decor1.setType(decor.getType());
	    	decor1.setPrice(decor.getPrice());
	    	decor1.setImage(decor.getImage());
	    	dao.save(decor1);
		}
		
	}

	@Override
	public GardenDecor getDecorById(int DecorId) {
		return dao.getDecorById(DecorId);
	}
	
	
	
	
}



