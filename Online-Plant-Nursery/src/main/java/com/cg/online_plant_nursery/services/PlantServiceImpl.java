package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.PlantDAO;
import com.cg.online_plant_nursery.entity.Plant;

@Service
public class PlantServiceImpl implements IPlantService{
@Autowired
PlantDAO dao;

@Override
public void addPlant(Plant plant) {
dao.save(plant);
}

@Override
public List<Plant> getAllPlants() {
List<Plant> plantList=dao.findAll();
 return plantList;
}
@Override
public void removePlant(int PlantId) {
if(dao.existsById(PlantId)) {
  dao.deleteById(PlantId);
 }
}

@Override
public void updatePlant(int PlantId, Plant plant) {
if(dao.existsById(PlantId)) {
  Plant plant1=dao.findById(PlantId).get();
     plant1.setName(plant.getName());
     plant1.setId(plant.getId());
     plant1.setType(plant.getType());
     plant1.setPrice(plant.getPrice());
     plant1.setDescription(plant.getDescription());
     plant1.setImage(plant.getImage());
  dao.save(plant1);
 }
}

@Override
public Plant getPlantById(int PlantId) {
return dao.getPlantById(PlantId);
}

}
