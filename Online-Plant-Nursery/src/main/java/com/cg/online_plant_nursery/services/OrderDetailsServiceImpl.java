package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.dao.OrderDetailsDAO;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.OrderDetails;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateOrderException;
import com.cg.online_plant_nursery.utils.InsufficiantBalanceException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.OrderDetailsNotFoundException;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService{
	@Autowired
	OrderDetailsDAO dao;
	@Autowired
	CustomerDAO customerdao;
	List<OrderDetails> orderDetailsList = new ArrayList<>();
	List<Customer> customerList = new ArrayList<>();
	
	@Override
	public void addOrderDetails(OrderDetails OrderDetails) throws DuplicateOrderException,CustomreNotFoundException,InsufficiantBalanceException {
		orderDetailsList = dao.findAll();
		Customer customer1 = customerdao.getCustomerById(OrderDetails.getCustomer().getId());
		if(dao.existsById(OrderDetails.getOrderId())) {
			throw new DuplicateOrderException();
		}
		if(customerdao.existsById(OrderDetails.getCustomer().getId())){
			if(customer1.getTotalamount() >= OrderDetails.getAmount()) {
				double amt = customer1.getTotalamount();
				amt-= OrderDetails.getAmount();
				customer1.setTotalamount(amt);
				customerdao.save(customer1);
				dao.save(OrderDetails);
			}
			throw new InsufficiantBalanceException();
			
		}
		throw new CustomreNotFoundException();
	}

	@Override
	public void updateOrderDetails(long OrderId, OrderDetails OrderDetails)
			throws OrderDetailsNotFoundException, CustomreNotFoundException {
		orderDetailsList = dao.findAll();
		for(OrderDetails od : orderDetailsList) {
			if(od.getOrderId() == OrderId) {
				customerList = customerdao.findAll();
					for(Customer c : customerList) {
						if(c.getId() == OrderDetails.getCustomer().getId()) {
							od.setOrderId(OrderDetails.getOrderId());
							od.setPaymentOption(OrderDetails.getPaymentOption());
							od.setDate(OrderDetails.getDate());
							od.setAmount(OrderDetails.getAmount());
							od.setCustomer(OrderDetails.getCustomer());
							dao.save(od);
							return;
						}
					}
					throw new CustomreNotFoundException();
			}
		}
		throw new OrderDetailsNotFoundException();
	}

	@Override
	public void deleteOrderDetails(long OrderId) throws OrderDetailsNotFoundException {
		orderDetailsList = dao.findAll();
		Customer customer1 = customerdao.getCustomerById(OrderId);
		
		for(OrderDetails od : orderDetailsList) {
			if(od.getOrderId() == OrderId) {
				customer1.setTotalamount(customer1.getTotalamount()+od.getAmount());
				customerdao.save(customer1);
				dao.deleteById( OrderId);
				return;
			}
		}
		throw new OrderDetailsNotFoundException();
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() throws ListIsEmptyException {
		orderDetailsList = dao.findAll();
		if(orderDetailsList == null) {
			throw new ListIsEmptyException();
		}
		return orderDetailsList;
	}

	@Override
	public OrderDetails getOrderDetailsById(long OrderId) throws OrderDetailsNotFoundException {
		orderDetailsList = dao.findAll();
		for(OrderDetails od : orderDetailsList) {
			if(od.getOrderId() == OrderId) {
				return od;
			}
		}
		throw new OrderDetailsNotFoundException();		
	}


}
