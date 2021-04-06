package com.cg.online_plant_nursery.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.dao.OrderDetailsDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.OrderDetails;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateOrderException;
import com.cg.online_plant_nursery.utils.InsufficiantBalanceException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;
import com.cg.online_plant_nursery.utils.OrderDetailsNotFoundException;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService{
	@Autowired
	OrderDetailsDAO dao;
	@Autowired
	CustomerDAO customerdao;
	@Autowired
	AdminDAO adminDao;
	@Autowired
	CartDAO cartDao;
	
	List<OrderDetails> orderDetailsList = new ArrayList<>();
	List<Customer> customerList = new ArrayList<>();
	List<Cart> cartList = new ArrayList<>();
	
//	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	 LocalDateTime now = LocalDateTime.now();
	 
	@Override
	public void addOrderDetails(long customerID,String paymentOp,long orderID) throws DuplicateOrderException,CustomreNotFoundException,InsufficiantBalanceException {
		orderDetailsList = dao.findAll();
		cartList = cartDao.findAll();
		boolean flag = false;
		double amt = 0;
		Customer customer1 = new Customer();
		OrderDetails odr = new OrderDetails();
		
		if(customerdao.existsById(customerID)){
			customer1 = customerdao.getCustomerById(customerID);
			for(Cart c : cartList) {
				if(c.getCustomer().getId() == customerID) {
					amt += c.getTotalamount();
				}
			}
			if(customer1.getTotalamount() >= amt) {
				double custamt = customer1.getTotalamount();
				custamt = custamt - amt;
				customer1.setTotalamount(custamt);
				customerdao.save(customer1);
				odr.setOrderId(orderID);
				odr.setCustomer(customer1);
				odr.setDate(java.time.LocalDateTime.now());
				odr.setPaymentOption(paymentOp);
				odr.setAmount(amt);
				dao.save(odr);
				for(Cart c : cartList) {
					if(c.getCustomer().getId() == customer1.getId()) {
						c.setPlant(null);
						c.setPlant_quantity(0);
						c.setPlanter(null);
						c.setPlanter_quantity(0);
						c.setFertilizer(null);
						c.setFertlizer_quantity(0);
						c.setSeed(null);
						c.setSeed_quantity(0);
						c.setGardendecor(null);
						c.setGarden_decor_quantity(0);
						c.setTotalamount(0);
						cartDao.save(c);
						if(flag == true) {
							cartDao.delete(c);
						}
						flag = true;
					}
				}
				return;
			}
			throw new InsufficiantBalanceException();
			
		}
		throw new CustomreNotFoundException();
	}

	@Override
	public void updateOrderDetails(long OrderId, OrderDetails OrderDetails) throws OrderDetailsNotFoundException, CustomreNotFoundException {
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
				od.setCustomer(null);
				dao.save(od);
				dao.deleteById( OrderId);
				return;
			}
		}
		throw new OrderDetailsNotFoundException();
	}

	@Override
	public List<OrderDetails> getAllOrderDetails(long adminID) throws ListIsEmptyException,NotAuthorizedException {
		orderDetailsList = dao.findAll();
		if(adminDao.existsById(adminID)) {
			if(orderDetailsList.isEmpty()) {
				throw new ListIsEmptyException();
			}
			return orderDetailsList;
		}
		throw new NotAuthorizedException();
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
