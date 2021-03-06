package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Planter;

@Repository
public interface PlanterDAO extends JpaRepository<Planter,Long>{
	
	//Query is defined
	 @Query(value = "from Planter planter where planter.id=?1")
	 public Planter getPlanterById(long id);
	
}
