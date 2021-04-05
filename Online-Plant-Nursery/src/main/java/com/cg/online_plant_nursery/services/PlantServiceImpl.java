package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.entity.Plant;

@Service
public class PlantServiceImpl  implements IPlantService{
	@Autowired
	PlantDAO dao;
	
	List<Plant> plantList = new ArrayList<>();
	@Override
	public void addPlant(Plant plant) throws DuplicateException {
		plantList = dao.findAll();
		for(Plant pl: plantList) {
			if(pl.getId() ==plant.getId()){
				throw new DuplicateException();
			}
		}
		dao.save(plant);
			}
	
	@Override
	public List<Plant> getAllPlants() throws ListIsEmptyException {
		 plantList=dao.findAll();
		 if(plantList == null) {
				throw new ListIsEmptyException();
			}
			return plantList;
	}
	
		@Override
	public void removePlant(int PlantId) throws IDNotFoundException{
		plantList = dao.findAll();
		for(Plant pl: plantList) {
			if(pl.getId()==PlantId) {
				 dao.deleteById(PlantId);
				 return;
			}
		}
		throw new IDNotFoundException();
			 		}
		@Override
	public void updatePlant(int PlantId, Plant plant)  throws IDNotFoundException{
		plantList = dao.findAll();
		for(Plant pl: plantList) {
			if(pl.getId()==PlantId) {
				Plant plant1=dao.findById(PlantId).get();
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

	 
	

