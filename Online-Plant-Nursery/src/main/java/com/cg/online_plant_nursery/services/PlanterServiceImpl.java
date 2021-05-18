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
	public void addPlanter(Planter planter) throws DuplicateException{
		planterList = dao.findAll();
			for(Planter pl: planterList) {
				if(pl.getId() ==planter.getId()){
					throw new DuplicateException();  //duplication of planters are not allowed
				}
			}
			dao.save(planter);
		
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
	public void updatePlanter(int id, Planter planter){
		
			 planterList = dao.findAll();
			 
				 for(Planter pl: planterList) {
						if(pl.getId()==id) {
							Planter planter1=dao.getPlanterById(id);
							   planter1.setId(planter.getId());
							      planter1.setName(planter.getName());
							      planter1.setType(planter.getType());
							      planter1.setPrice(planter.getPrice());
							     
							      planter1.setImage(planter.getImage());
							   dao.save(planter1);
						   return;
								}
					
	}}
	@Override
	public Planter getPlanterById(int planterId)throws IDNotFoundException {
		planterList = dao.findAll();
		for(Planter pl: planterList) {
			if(pl.getId()== planterId) {
				return pl;
			}
		}
		throw new IDNotFoundException();              //planter Id is not found 
	}

	@Override
	public void deletePlanter(int planterId) throws IDNotFoundException {
		planterList = dao.findAll();
		
			for(Planter pl: planterList) {
				if(pl.getId()==planterId) {
					 dao.deleteById((long) planterId);
					 return;
				}
			}
			throw new IDNotFoundException();    //planter Id is not found 
		
	
		
	}
	
}
