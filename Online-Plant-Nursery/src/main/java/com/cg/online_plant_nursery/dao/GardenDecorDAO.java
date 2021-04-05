package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.GardenDecor;

@Repository
public interface GardenDecorDAO extends JpaRepository<GardenDecor,Integer> {

	@Query(value = "from GardenDecor decor where decor.id=?1")
	public GardenDecor getDecorById(long id);
}
