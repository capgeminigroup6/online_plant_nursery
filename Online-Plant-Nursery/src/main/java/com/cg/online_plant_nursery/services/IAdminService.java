package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Admin;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;

public interface IAdminService {
	public void addAdmin(long adminID,Admin admin) throws DuplicateException,NotAuthorizedException;
	public void removeAdmin(long adminID,long admin_id) throws IDNotFoundException,NotAuthorizedException;
	public List<Admin> getAllAdmin(long adminID) throws ListIsEmptyException,NotAuthorizedException;
	public Admin getAdminById(long adminID,long admin_id) throws IDNotFoundException,NotAuthorizedException;
}
