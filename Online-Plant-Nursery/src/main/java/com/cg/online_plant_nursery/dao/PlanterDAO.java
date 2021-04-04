package com.cg.online_plant_nursery.dao;

@Repository
public interface PlanterDAO extends JpaRepository<Planter,Integer>{
	
	 @Query(value = "from Planter planter where planter.id=?1")
	 public Planter getPlanterById(int id);
	 
}
