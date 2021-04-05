package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.entity.Customer;

@Service
public class CustomerServiceImpl {
	@Autowired
	CustomerDAO dao;

public void addCustomer(Customer customer)
{
	dao.save(customer);
}

public void removeCustomer(long customer_id) {
	dao.deleteById((int) customer_id);
}

public void updateCustomer(long customer_id,Customer customer) {
	Customer customer1=dao.getOne((int) customer_id);
	customer1.setId(customer.getId());
	customer1.setName(customer.getName());
	customer1.setEmail(customer.getEmail());
	customer1.setPassword(customer.getPassword());
	customer1.setContactnumber(customer.getContactnumber());
	customer1.setTotalamount(customer.getTotalamount());
	dao.save(customer); 
}

public List<Customer> getAllCustomer()
{
	return dao.findAll();
}

public Customer getCustomerById(long customer_id)
{
	return dao.getCustomerById((int) customer_id);
}
}