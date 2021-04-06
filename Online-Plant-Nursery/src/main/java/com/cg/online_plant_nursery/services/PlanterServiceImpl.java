package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.PlanterDAO;
import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service
public class PlanterServiceImpl implements IPlanterService{
	@Autowired
	PlanterDAO dao;
	@Autowired
	AdminDAO admindao;
  List <Planter>planterList = new ArrayList<>();
	@Override
	public void addPlanter(long adminID,Planter planter) throws DuplicateException,NotAuthorizedException{
		planterList = dao.findAll();
		if(admindao.existsById(adminID)){
			for(Planter pl: planterList) {
				if(pl.getId() ==planter.getId()){
					throw new DuplicateException();
				}
			}
			dao.save(planter);
			return;
		}
		throw new NotAuthorizedException();
}
	
	@Override
	public List<Planter> getAllPlanters() throws ListIsEmptyException {
		 planterList=dao.findAll();
		   if(planterList == null) {
						throw new ListIsEmptyException();
					}
					return planterList;
	}

	

	@Override
	public void removePlanter(long adminID,int PlanterId) throws IDNotFoundException,NotAuthorizedException{
		
			planterList = dao.findAll();
			if(admindao.existsById(adminID)){
				for(Planter pl: planterList) {
					if(pl.getId()==PlanterId) {
						 dao.deleteById((long) PlanterId);
						 return;
					}
				}
				throw new IDNotFoundException();
			}
			throw new NotAuthorizedException();
		}
		
	

	@Override
	public void updatePlanter(long adminID,int PlanterId, Planter planter) throws IDNotFoundException,NotAuthorizedException{
		
			 planterList = dao.findAll();
			 if(admindao.existsById(adminID)){
				 for(Planter pl: planterList) {
						if(pl.getId()==PlanterId) {
							Planter planter1=dao.findById((long) PlanterId).get();
							   planter1.setId(planter.getId());
							      planter1.setName(planter.getName());
							      planter1.setType(planter.getType());
							      planter1.setPrice(planter.getPrice());
							     
							      planter1.setImage(planter.getImage());
							   dao.save(planter1);
						   return;
								}
					}
					 throw new IDNotFoundException();
			 }
				throw new NotAuthorizedException();
	}
	@Override
	public Planter getPlanterById(int PlanterId)throws IDNotFoundException {
		planterList = dao.findAll();
		for(Planter pl: planterList) {
			if(pl.getId()== PlanterId) {
				return pl;
			}
		}
		throw new IDNotFoundException();
	}
	
}
