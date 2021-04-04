package com.cg.online_plant_nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.entity.Customer;

//@Service
//public class CustomerServiceImpl {
//@Autowired
//CustomerDAO dao;
//
//public void addCustomer(Customer customer)
//{
//	dao.save(customer);
//}
//
//public void removeCustomer(long customer_id) {
//	dao.deleteById((int) customer_id);
//}
//
//public void updateCustomer(long customer_id,Customer customer) {
//	Customer customer1=dao.getOne((int) customer_id);
//	customer1.setId(customer.getId());
//	dao.save(customer); 
//}
//
//public List<Customer> getAllCustomer()
//{
//	List<Customer> customerList=dao.findAll();
//	return customerList;
//}
//
//public Customer getCustomerById(long customer_id)
//{
//	Customer customer=dao.getOne(customer);
//	return dao.getCustomerById(customer_id);
//}
//}