package com.cg.online_plant_nursery.dao;


@Repository
public interface FertilizerDAO extends JpaRepository<Fertilizer,Integer>{
	@Query(value = "from Fertilizer fertilizer where fertilizer.id=?1")
	 public Fertilizer getFertilizerById(int id);
	
}
