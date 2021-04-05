package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{
	
	@Query(value = "from Cart cart where cart.id=?1")
	 public Cart getCartById(long id);
}
