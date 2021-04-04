package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.PlanterDAO;
import com.cg.online_plant_nursery.entity.Planter;

@Service
public class PlanterServiceImpl implements IPlanterService{
@Autowired
PlanterDAO dao;

@Override
public void addPlanter(Planter planter) {
dao.save(planter);

}
@Override
public List<Planter> getAllPlanters() {
List<Planter> planterList=dao.findAll();
 return planterList;
}



@Override
public void removePlanter(int PlanterId) {
if(dao.existsById(PlanterId)) {
  dao.deleteById(PlanterId);
 }

}

@Override
public void updatePlanter(int PlanterId, Planter planter) {
if(dao.existsById(PlanterId)) {
  Planter planter1=dao.findById(PlanterId).get();
  planter1.setId(planter.getId());
     planter1.setName(planter.getName());
     planter1.setType(planter.getType());
     planter1.setPrice(planter.getPrice());
   
     planter1.setImage(planter.getImage());
  dao.save(planter1);
 }

}

@Override
public Planter getPlanterById(int PlanterId) {
return dao.getPlanterById(PlanterId);
}

}
