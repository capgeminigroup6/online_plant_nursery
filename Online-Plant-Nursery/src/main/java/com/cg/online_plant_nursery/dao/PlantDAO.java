package com.cg.online_plant_nursery.dao;

@Repository
public interface PlantDAO extends JpaRepository<Plant,Integer>{

	@Query(value = "from Plant plant where plant.id=?1")
	 public Plant getPlantById(int id);
	
}
