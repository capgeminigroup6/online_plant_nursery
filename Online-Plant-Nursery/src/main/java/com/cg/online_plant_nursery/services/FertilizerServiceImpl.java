package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.FertilizerDAO;
import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service
public class FertilizerServiceImpl implements IFertilizerService{
	@Autowired
	FertilizerDAO dao;
	@Autowired
	AdminDAO adminDAO;
	List<Fertilizer> fertilizerList = new ArrayList<>();

	@Override
	public void addFertilizer(Fertilizer fertilizer) throws DuplicateException{
		fertilizerList = dao.findAll();

			for(Fertilizer  fl: fertilizerList) {
				if(fl.getId() ==fertilizer.getId()){
					throw new DuplicateException();
				}
			}
			dao.save(fertilizer);
			return;
	
			}

	@Override
	public List<Fertilizer> getAllFertilizers() throws ListIsEmptyException {
		 fertilizerList=dao.findAll();
		 if(fertilizerList.isEmpty()) {
				throw new ListIsEmptyException();
			}
			
		  return fertilizerList;
	}

	@Override
	public void removeFertilizer(int FertilizerId)throws IDNotFoundException {
		fertilizerList = dao.findAll();
	
			for(Fertilizer fl: fertilizerList) {
				if(fl.getId()==FertilizerId) {
					 dao.deleteById((long) FertilizerId);
					 return;
				}
			}
			throw new IDNotFoundException();
		}
		
	
	

	@Override
	public void updateFertilizer(int FertilizerId, Fertilizer fertilizer) {
		fertilizerList = dao.findAll();
		
			for(Fertilizer fl: fertilizerList) {
				if(fl.getId()==FertilizerId) {
				   Fertilizer fertilizer1=dao.getFertilizerById(FertilizerId);
				   fertilizer1.setId(fertilizer.getId());
				   fertilizer1.setName(fertilizer.getName());
				   fertilizer1.setType(fertilizer.getType());
				   fertilizer1.setPrice(fertilizer.getPrice());
				   fertilizer1.setDescription(fertilizer.getDescription());
				   fertilizer1.setImage(fertilizer.getImage());
				   dao.save(fertilizer1);
				   return;
				  }
			}
			 throw new IDNotFoundException();
		}

	
	@Override
	public Fertilizer getFertilizerById(int FertilizerId) throws IDNotFoundException{
		fertilizerList = dao.findAll();
		for(Fertilizer fl: fertilizerList) {
			if(fl.getId()== FertilizerId) {
				return fl;
			}
		}
		throw new IDNotFoundException();
	}

	

}

