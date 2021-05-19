package com.cg.online_plant_nursery.services;


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
	CustomerDAO customerdao;		//autowires these services with repository classes
	@Autowired
	AdminDAO adminDao;
	@Autowired
	CartDAO cartDao;
	
	List<OrderDetails> orderDetailsList = new ArrayList<>();
	List<Customer> customerList = new ArrayList<>();
	List<Cart> cartList = new ArrayList<>();

	 
	@Override
	public void addOrderDetails(long customerID,String paymentOp,String shipping_address) throws DuplicateOrderException,CustomreNotFoundException,InsufficiantBalanceException {
		orderDetailsList = dao.findAll();
		cartList = cartDao.findAll();
		boolean flag = false;
		double amt = 0;
		Customer customer1;
		OrderDetails odr = new OrderDetails();
		
		if(customerdao.existsById(customerID)){
			customer1 = customerdao.getCustomerById(customerID);
			for(Cart c : cartList) {
				if(c.getCustomer().getId() == customerID) {			
					amt += c.getTotalamount();					//get total cart amount
				}
			}
			
				if(paymentOp.equals("Account Wallet")) {
					double custamt = customer1.getTotalamount();
					custamt = custamt - amt;
					customer1.setTotalamount(custamt);			//updates the customer wallet amount after buy 
					customerdao.save(customer1);
				}
				odr.setCustomer(customer1);
				odr.setDate(java.time.LocalDateTime.now());
				odr.setShipping_address(shipping_address);
				odr.setPaymentOption(paymentOp);			//create new order details
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
						c.setSeed(null);					//update the cart products to null
						c.setSeed_quantity(0);
						c.setGardendecor(null);
						c.setGarden_decor_quantity(0);
						c.setTotalamount(0);
						cartDao.save(c);
						if(flag == true) {
							cartDao.delete(c);				//if one cart already there for customer,delete the remaining empty carts
						}
						flag = true;
					}
				}
				return;
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
		OrderDetails order = dao.getOrderDetailsById(OrderId);
		Customer customer1 = customerdao.getCustomerById(order.getCustomer().getId());
		
		for(OrderDetails od : orderDetailsList) {
			if(od.getOrderId() == OrderId) {
				if(order.getPaymentOption().equals("Account Wallet")) {
					customer1.setTotalamount(customer1.getTotalamount() + od.getAmount());		//refund the amount
					customerdao.save(customer1);
				}
				od.setCustomer(null);
				dao.save(od);
				dao.deleteById(OrderId);
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
				throw new ListIsEmptyException();		//if list is empty
			}
			return orderDetailsList;
		}
		throw new NotAuthorizedException();	 //only admin can access these
	}

	@Override
	public List<OrderDetails> getOrderDetailsById(long customerID) throws OrderDetailsNotFoundException {
		orderDetailsList = dao.findAll();
		List<OrderDetails> orderList = new ArrayList<>();
		for(OrderDetails od : orderDetailsList) {
			if(od.getCustomer().getId() == customerID) {
				orderList.add(od);			}
		}
		return orderList;
	}


}
