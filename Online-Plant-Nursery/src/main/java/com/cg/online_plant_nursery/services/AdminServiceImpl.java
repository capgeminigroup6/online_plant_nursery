package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.entity.Admin;

@Service
public class AdminServiceImpl {
@Autowired
AdminDAO dao;

public void addAmin(Admin admin)
{
	dao.save(admin);
}

public void removeAdmin(long admin_id) {
	dao.deleteById((int) admin_id);
}

public List<Admin> getAllAdmin()
{
	List<Admin> adminList=dao.findAll();
	return adminList;
}

public Admin getAdminById(long admin_id)
{
	Admin admin=dao.getOne((int) admin_id);
	return admin;
}
}