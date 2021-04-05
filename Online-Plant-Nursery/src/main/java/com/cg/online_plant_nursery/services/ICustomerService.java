package com.cg.online_plant_nursery.services;

import java.util.List;

import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

public interface ICustomerService {
	public void addCustomer(Customer customer) throws DuplicateException;
	public void removeCustomer(long customer_id) throws IDNotFoundException;
	public void updateCustomer(long customer_id,Customer customer) throws IDNotFoundException;
	public List<Customer> getAllCustomer() throws ListIsEmptyException;
	public Customer getCustomerById(long customer_id) throws IDNotFoundException;
}
