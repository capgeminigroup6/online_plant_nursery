package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Plant;

@Repository
public interface PlantDAO extends JpaRepository<Plant,Integer>{

	@Query(value = "from Plant plant where plant.id=?1")
	 public Plant getPlantById(int id);
	
}
