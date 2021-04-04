package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	Customer getCustomerById(long customer_id);

}
