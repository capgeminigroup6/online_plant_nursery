package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.entity.Admin;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service
public class AdminServiceImpl implements IAdminService{
@Autowired		//autowires this service with repository class
AdminDAO dao;

public void addAdmin(long adminID,Admin admin) throws DuplicateException,NotAuthorizedException
{
	if(dao.existsById(adminID)) {
		if(dao.existsById(admin.getId())) {
			throw new DuplicateException();	//duplication of id not allowed
		}
		dao.save(admin);
	}
	throw new NotAuthorizedException();  // Checks for admin user
}

public void removeAdmin(long adminID,long admin_id) throws IDNotFoundException,NotAuthorizedException{
	if(dao.existsById(adminID)) {
		if(dao.existsById(admin_id)) {
			Admin admin1 = dao.getAdminById(admin_id);
			admin1.setCustomer(null);
			dao.save(admin1);
			dao.delete(admin1);
			return;
		}
		throw new IDNotFoundException();  //if the ID value not found in the database
	}
	throw new NotAuthorizedException();   // Checks for admin user
}

public List<Admin> getAllAdmin(long adminID) throws ListIsEmptyException,NotAuthorizedException
{
	if(dao.existsById(adminID)) {
		List<Admin> adminList=dao.findAll();
		if(adminList.isEmpty()) {
			throw new ListIsEmptyException();  //if the output list is empty
		}
		return adminList;
	}
	throw new NotAuthorizedException();
}

public Admin getAdminById(long adminID,long admin_id) throws IDNotFoundException,NotAuthorizedException
{
	if(dao.existsById(adminID)) {
		if(dao.existsById(admin_id)) {
			return dao.getAdminById(admin_id);
		}
		throw new IDNotFoundException();  //if the ID value not found in the database
	}
	throw new NotAuthorizedException();  // Checks for admin user
	
}

}