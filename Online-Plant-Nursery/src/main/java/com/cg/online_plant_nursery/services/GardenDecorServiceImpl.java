package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service
public class GardenDecorServiceImpl implements IGardenDecorService{
	@Autowired
  GardenDecorDAO dao;
	@Autowired
	AdminDAO adminDAO;
	
	List<GardenDecor> decorList = new ArrayList<>();
	@Override
	public void addDecor(long adminID,GardenDecor decor) throws DuplicateException ,NotAuthorizedException{
	    decorList = dao.findAll();
	    if(adminDAO.existsById(adminID)) {
	    	for(GardenDecor gd: decorList) {
				if(gd.getId() ==decor.getId()){
					throw new DuplicateException();
				}
			}
			dao.save(decor);
			return;
	    }
		throw new NotAuthorizedException();
			}
	
	@Override
	public List<GardenDecor> getAllDecors() throws ListIsEmptyException {
		 decorList=dao.findAll();
		 if(decorList == null) {
				throw new ListIsEmptyException();
			}
			return decorList;
	}
	@Override
	public void removeDecor(long adminID,int Id) throws IDNotFoundException,NotAuthorizedException{
		decorList = dao.findAll();
		 if(adminDAO.existsById(adminID)) {
			 for(GardenDecor gd: decorList) {
					if(gd.getId()==Id) {
						 dao.deleteById((long) Id);
						 return;
					}
				}
				throw new IDNotFoundException();
		 }
		 throw new NotAuthorizedException();
			 		}
		@Override
	public void updateGardenDecor(long adminID,int Id, GardenDecor decor)  throws IDNotFoundException,NotAuthorizedException{
		decorList = dao.findAll();
		if(adminDAO.existsById(adminID)) {
			for(GardenDecor gd: decorList) {
				if(gd.getId()==Id) {
					GardenDecor decor1=dao.findById((long) Id).get();
				     decor1.setId(decor.getId());
				     decor1.setName(decor.getName());
				     decor1.setPrice(decor.getPrice());
				     decor1.setType(decor.getType());
				     decor1.setImage(decor.getImage());
				     dao.save(decor1);
				      return;
						}
			}
			 throw new IDNotFoundException();
		}
		throw new NotAuthorizedException();
		}
		@Override
	public GardenDecor getDecorById(int Id) throws IDNotFoundException {
		decorList = dao.findAll();
		for(GardenDecor gd: decorList) {
			if(gd.getId()== Id) {
				return gd;
			}
		}
		throw new IDNotFoundException();
	}
}



