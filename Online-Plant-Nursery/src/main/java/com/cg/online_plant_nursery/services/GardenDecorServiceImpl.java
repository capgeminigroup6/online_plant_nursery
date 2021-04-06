package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.GardenDecorDAO;
import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

@Service
public class GardenDecorServiceImpl implements IGardenDecorService{
	@Autowired
  GardenDecorDAO dao;

	List<GardenDecor> decorList = new ArrayList<>();
	@Override
	public void addDecor(GardenDecor decor) throws DuplicateException {
	    decorList = dao.findAll();
		for(GardenDecor gd: decorList) {
			if(gd.getId() ==decor.getId()){
				throw new DuplicateException();
			}
		}
		dao.save(decor);
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
	public void removeDecor(int Id) throws IDNotFoundException{
		decorList = dao.findAll();
		for(GardenDecor gd: decorList) {
			if(gd.getId()==Id) {
				 dao.deleteById((long) Id);
				 return;
			}
		}
		throw new IDNotFoundException();
			 		}
		@Override
	public void updateGardenDecor(int Id, GardenDecor decor)  throws IDNotFoundException{
		decorList = dao.findAll();
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



