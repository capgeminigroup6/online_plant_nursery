package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Fertilizer;

@Repository
public interface FertilizerDAO extends JpaRepository<Fertilizer,Integer>{
	@Query(value = "from Fertilizer fertilizer where fertilizer.id=?1")
	 public Fertilizer getFertilizerById(int id);
	
}
