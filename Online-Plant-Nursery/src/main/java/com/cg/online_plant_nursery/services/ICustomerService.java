package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Customer;

public interface ICustomerService {
	public void addCustomer(Customer customer);
	public void removeCustomer(long customer_id);
	public void updateCustomer(long customer_id,Customer customer);
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(long customer_id);
}
