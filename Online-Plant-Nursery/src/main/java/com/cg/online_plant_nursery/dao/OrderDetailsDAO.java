package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.OrderDetails;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Integer>{

}
