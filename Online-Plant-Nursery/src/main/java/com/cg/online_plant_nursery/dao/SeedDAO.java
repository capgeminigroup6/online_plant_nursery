package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Seed;

@Repository
public interface SeedDAO extends JpaRepository<Seed,Integer> {

	@Query(value = "from Seed seed where seed.id=?1")
	public Seed getSeedById(long id);
}