package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Long>{
	@Query(value = "from Admin admin where admin.id=?1")
	 public Admin getAdminById(long id);
}
