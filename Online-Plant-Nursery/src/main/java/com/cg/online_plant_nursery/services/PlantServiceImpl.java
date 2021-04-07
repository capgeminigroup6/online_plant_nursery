package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service    
public class PlantServiceImpl  implements IPlantService{
	@Autowired
	PlantDAO dao;
	@Autowired
	AdminDAO adminDAO;
	
	List<Plant> plantList = new ArrayList<>();
	@Override
	public void addPlant(long adminID,Plant plant) throws DuplicateException,NotAuthorizedException {
		plantList = dao.findAll();
		if(adminDAO.existsById(adminID)) {
			for(Plant pl: plantList) {
				if(pl.getId() ==plant.getId()){
					throw new DuplicateException();
				}
			}
			dao.save(plant);
			return;
		}
		throw new NotAuthorizedException();
	}
	
	@Override
	public List<Plant> getAllPlants() throws ListIsEmptyException {
		 plantList=dao.findAll();
		 if(plantList.isEmpty()) {
				throw new ListIsEmptyException();
			}
			return plantList;
	}
	
		@Override
	public void removePlant(long adminID,int PlantId) throws IDNotFoundException,NotAuthorizedException{
		plantList = dao.findAll();
		if(adminDAO.existsById(adminID)) {
			for(Plant pl: plantList) {
				if(pl.getId()==PlantId) {
					 dao.deleteById((long) PlantId);
					 return;
				}
			}
			throw new IDNotFoundException();
		}
		throw new NotAuthorizedException();
	 }
		
		@Override
	public void updatePlant(long adminID,int PlantId, Plant plant)  throws IDNotFoundException,NotAuthorizedException{
		plantList = dao.findAll();
		if(adminDAO.existsById(adminID)) {
			for(Plant pl: plantList) {
				if(pl.getId()==PlantId) {
					Plant plant1=dao.getPlantById(PlantId);
				      plant1.setId(plant.getId());
				      plant1.setName(plant.getName());
				      plant1.setType(plant.getType());
				      plant1.setPrice(plant.getPrice());
				      plant1.setDescription(plant.getDescription());
				      plant1.setImage(plant.getImage());
				   dao.save(plant1);
				   return;
						}
			}
			 throw new IDNotFoundException();
		}
		throw new NotAuthorizedException();
		}
		@Override
	public Plant getPlantById(int PlantId) throws IDNotFoundException {
		plantList = dao.findAll();
		for(Plant pl: plantList) {
			if(pl.getId()== PlantId) {
				return pl;
			}
		}
		throw new IDNotFoundException();
	}
}

	 
	

