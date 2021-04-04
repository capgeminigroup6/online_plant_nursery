package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.FertilizerDAO;
import com.cg.online_plant_nursery.entity.Fertilizer;

@Service
public class FertilizerServiceImpl implements IFertilizerService{
@Autowired
FertilizerDAO dao;

@Override
public void addFertilizer(Fertilizer fertilizer) {
dao.save(fertilizer);

}

@Override
public List<Fertilizer> getAllFertilizers() {
List<Fertilizer> fertilizerList=dao.findAll();
 return fertilizerList;
}

@Override
public void removeFertilizer(int FertilizerId) {
if(dao.existsById(FertilizerId)) {
  dao.deleteById(FertilizerId);
 }

}

@Override
public void updateFertilizer(int FertilizerId, Fertilizer fertilizer) {
if(dao.existsById(FertilizerId)) {
  Fertilizer fertilizer1=dao.findById(FertilizerId).get();
  fertilizer1.setName(fertilizer.getName());
  fertilizer1.setId(fertilizer.getId());
  fertilizer1.setPrice(fertilizer.getPrice());
  fertilizer1.setType(fertilizer.getType());
  fertilizer1.setDescription(fertilizer.getDescription());
  fertilizer1.setImage(fertilizer.getImage());
  dao.save(fertilizer1);
 }

}

@Override
public Fertilizer getFertilizerById(int FertilizerId) {
return dao.getFertilizerById(FertilizerId);
}
}
