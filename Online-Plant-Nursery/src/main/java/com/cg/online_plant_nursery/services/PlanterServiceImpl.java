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
					throw new DuplicateException();  //duplication of planters are not allowed
				}
			}
			dao.save(planter);
			return;
		}
		throw new NotAuthorizedException();         //only Admin has authorized access
}
	
	@Override
	public List<Planter> getAllPlanters() throws ListIsEmptyException {
		 planterList=dao.findAll();
		   if(planterList.isEmpty()) {
						throw new ListIsEmptyException();  //planter list is null
					}
					return planterList;
	}

	

	@Override
	public void removePlanter(long adminID,int planterId) throws IDNotFoundException,NotAuthorizedException{
		
			planterList = dao.findAll();
			if(admindao.existsById(adminID)){
				for(Planter pl: planterList) {
					if(pl.getId()==planterId) {
						 dao.deleteById((long) planterId);
						 return;
					}
				}
				throw new IDNotFoundException();    //planter Id is not found 
			}
			throw new NotAuthorizedException();    //only Admin has authorized access
		}
		
	

	@Override
	public void updatePlanter(long adminID,int planterId, Planter planter) throws IDNotFoundException,NotAuthorizedException{
		
			 planterList = dao.findAll();
			 if(admindao.existsById(adminID)){
				 for(Planter pl: planterList) {
						if(pl.getId()==planterId) {
							Planter planter1=dao.getPlanterById(planterId);
							   planter1.setId(planter.getId());
							      planter1.setName(planter.getName());
							      planter1.setType(planter.getType());
							      planter1.setPrice(planter.getPrice());
							     
							      planter1.setImage(planter.getImage());
							   dao.save(planter1);
						   return;
								}
					}
					 throw new IDNotFoundException();   //planter Id is not found 
			 }
				throw new NotAuthorizedException();     //only Admin has authorized access
	}
	@Override
	public Planter getPlanterById(int planterId)throws IDNotFoundException {
		planterList = dao.findAll();
		for(Planter pl: planterList) {
			if(pl.getId()== planterId) {
				return pl;
			}
		}
		throw new IDNotFoundException();               //planter Id is not found 
	}
	
}
