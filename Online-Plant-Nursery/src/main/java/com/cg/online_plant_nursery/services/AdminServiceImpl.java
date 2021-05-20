package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.entity.Admin;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

@Service
public class AdminServiceImpl implements IAdminService{
@Autowired		//autowires this service with repository class
AdminDAO dao;
@Autowired	
CustomerDAO customerdao;
@Autowired
CartDAO cartdao;
List<Customer> CustomerList = new ArrayList<>();
List<Admin> AdminList = new ArrayList<>();
List<Cart> cartList = new ArrayList<>();

public void addAdmin(/*long adminID,*/Admin admin) throws DuplicateException,NotAuthorizedException
{
	//if(dao.existsById(adminID)) {
		if(dao.existsById(admin.getId())) {
			throw new DuplicateException();	//duplication of id not allowed
		}
		dao.save(admin);
		return;
	//}
	//throw new NotAuthorizedException();  // Checks for admin user
}

public void removeAdmin(/*long adminID,*/long admin_id) throws IDNotFoundException,NotAuthorizedException{
	AdminList = dao.findAll();
	CustomerList = customerdao.findAll();
	long customerid=0;
	long adminid=0;

	for(Admin ad : AdminList) {
		if(ad.getCustomer()!=null && ad.getCustomer().getId()==admin_id) {
			customerid=ad.getCustomer().getId();
			adminid=ad.getId();
			ad.setCustomer(null);
			//ad.setId(0);
		}
	}
	for(Customer od : CustomerList) {
		if(od.getId() == admin_id) {
			cartList = cartdao.findAll();
			for(Cart c : cartList) {
				if(c.getCustomer().getId() == admin_id) {
					c.setPlant(null);
					c.setPlanter(null);
					c.setFertilizer(null);
					c.setSeed(null);
					c.setGardendecor(null);
					cartdao.save(c);
					cartdao.delete(c);
				}
			}
			dao.deleteById(adminid);
		 //customerdao.deleteById( customerid);
			return;
		}
	}
		throw new IDNotFoundException();  //if the ID value not found in the database
	//}
	//throw new NotAuthorizedException();   // Checks for admin user
}

public List<Admin> getAllAdmin() throws ListIsEmptyException,NotAuthorizedException
{
	//if(dao.existsById(adminID)) {
		List<Admin> adminList=dao.findAll();
		if(adminList.isEmpty()) {
			throw new ListIsEmptyException();  //if the output list is empty
		}
		return adminList;
	//}
	//throw new NotAuthorizedException();
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