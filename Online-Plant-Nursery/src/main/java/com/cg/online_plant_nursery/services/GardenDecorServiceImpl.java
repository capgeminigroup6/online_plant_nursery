package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.entity.GardenDecor;

//@Service
//public class GardenDecorServiceImpl implements IGardenDecorService{
//	@Autowired
//	GardenDecorDAO dao;
//	
//	public void addDecor(GardenDecor decor) {
//		dao.save(decor);
//	}
//	public List<GardenDecor> getAllDecors(){
//		List<GardenDecor> decorList=dao.findAll();
//		return decorList;
//	}
//	public GardenDecor getDecorById(int DecorId) {
//		return dao.getDecorById(DecorId);
//	}
//	
//	public void removeDecor(int DecorId) {
//		if(dao.existsById(DecorId)) {
//			dao.removeById(DecorId);
//		}
//
//	}
//	public void updateDecor(int DecorId,Decor decor) {
//		if(dao.existsById(DecorId)) {
//			Decor decor=dao.findById(DecorId).get();
//	    	Decor.setName(decor.getName());
//	    	Decor.setId(decor.getId());
//	    	Decor.setPrice(seed.getPrice());
//	    	Decor.setImage(decor.getImage());
//			dao.save(decor);
//		}
//	
//	}
//
//}
