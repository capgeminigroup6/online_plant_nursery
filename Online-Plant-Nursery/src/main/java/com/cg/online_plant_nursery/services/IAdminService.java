package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Admin;

public interface IAdminService {
	public void addAdmin(Admin admin);
	public void removeAdmin(long admin_id);
	public void updateAdmin(long admin_id,Admin admin);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(long admin_id);
}
