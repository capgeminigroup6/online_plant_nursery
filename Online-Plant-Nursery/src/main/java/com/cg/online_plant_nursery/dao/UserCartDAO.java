package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.UserCart;

@Repository
public interface UserCartDAO extends JpaRepository<UserCart, Long> {
	@Modifying
	@Query(value = "truncate table UserCart",nativeQuery = true)
	public void clearUserTable();
}
