package com.cg.online_plant_nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.online_plant_nursery.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{

	@Query(value = "from Customer customer where customer.id=?1")
	public Customer getCustomerById(long id);

}
