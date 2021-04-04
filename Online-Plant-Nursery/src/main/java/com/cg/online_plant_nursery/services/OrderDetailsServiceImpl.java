package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.OrderDetailsDAO;
import com.cg.online_plant_nursery.entity.OrderDetails;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateOrderException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.OrderDetailsNotFoundException;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService{
	@Autowired
	OrderDetailsDAO dao;
	List<OrderDetails> orderDetailsList = new ArrayList<>();
	
	@Override
	public void addOrderDetails(OrderDetails OrderDetails) throws DuplicateOrderException {
		orderDetailsList = dao.findAll();
		for(OrderDetails od : orderDetailsList) {
			if(od.getOrderId() == OrderDetails.getOrderId()) {
				throw new DuplicateOrderException();
			}
		}
		dao.save(OrderDetails);
	}

	@Override
	public void updateOrderDetails(long OrderId, OrderDetails OrderDetails)
			throws OrderDetailsNotFoundException, CustomreNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetails(long OrderId) throws OrderDetailsNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllOrderDetails() throws ListIsEmptyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOrderDetailsById(long OrderId) throws OrderDetailsNotFoundException {
		// TODO Auto-generated method stub
		
	}


}
