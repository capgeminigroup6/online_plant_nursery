package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.entity.Planter;
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
	public List<Plant> getAllPlants() throws ListIsEmptyException {
		 plantList=dao.findAll();
		 if(plantList.isEmpty()) {
				throw new ListIsEmptyException();     //plant list is null
			}
			return plantList;
	}
	
		
		
		@Override
	public void updatePlant(int id, Plant plant)  throws IDNotFoundException{
		plantList = dao.findAll();
		
			for(Plant pl: plantList) {
				if(pl.getId()==id) {
					Plant plant1=dao.getPlantById(id);
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
			 throw new IDNotFoundException();       //plant Id is not found 
	
		}

		@Override
		public Plant getPlantById(int plantId) throws IDNotFoundException {
			plantList = dao.findAll();
			for(Plant pl: plantList) {
				if(pl.getId()== plantId) {
					return pl;
				}
			}
			throw new IDNotFoundException();            //plant Id is not found 
		}

			

		@Override
		public void addPlant(Plant plant) throws DuplicateException {
			plantList = dao.findAll();
			
				for(Plant pl: plantList) {
					if(pl.getId() ==plant.getId()){
						throw new DuplicateException();  //duplication of planters are not allowed
					}
				}
				dao.save(plant);
				return;
			}

		@Override
		public void deletePlant(int plantId)  {
			plantList = dao.findAll();
			
			for(Plant pl: plantList) {
				if(pl.getId()==plantId) {
					 dao.deleteById((long) plantId);
					 return;
				}
			}
			       //plant Id is not found 
		
	 }
			
		
		

		

		
}

	 
	


	 
	

