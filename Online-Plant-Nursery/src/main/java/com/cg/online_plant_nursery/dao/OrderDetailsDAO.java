package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.OrderDetails;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long>{
	@Query(value = "from OrderDetails order where order.OrderId=?1")
	 public OrderDetails getOrderDetailsById(long id);
}
