package com.cg.online_plant_nursery.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.AdminDAO;
import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.Admin;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;
import com.cg.online_plant_nursery.utils.NotAuthorizedException;


@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	CustomerDAO dao;
	@Autowired
	AdminDAO admindao;		//autowires these services with repository classes
	@Autowired
	CartDAO cartdao;
	List<Admin> AdminList = new ArrayList<>();
	List<Customer> CustomerList = new ArrayList<>();
	List<Cart> cartList = new ArrayList<>();
	
	public Customer validate(String email,String password) {
		Customer customer=dao.validate(email, password);
		return customer;
	}
	@Override
	public void addCustomer(Customer Customer) throws DuplicateException {
		Admin admin1= new Admin();
		if(dao.getCustomerById(Customer.getId()) != null) {
			throw new DuplicateException();	
		}
		else {
			dao.save(Customer);
			if(Customer.getRole().equals("admin")) {
				admin1.setCustomer(dao.getCustomerById(Customer.getId()));
				admindao.save(admin1);
			}
			
			
		}
		Cart cart = new Cart();
		cart.setCustomer(dao.getCustomerById(Customer.getId()));
		cart.setTotalamount(0);
		cartdao.save(cart);
	}
	@Override
	public void updateCustomer(long customer_id, Customer Customer) throws CustomreNotFoundException {
		CustomerList = dao.findAll();
				CustomerList = dao.findAll();
					for(Customer c : CustomerList) {
						if(c.getId() == Customer.getId()) {
							c.setId(Customer.getId());
							c.setName(Customer.getName());
							c.setEmail(Customer.getEmail());
							c.setPassword(Customer.getPassword());
							c.setContactnumber(Customer.getContactnumber());
							c.setTotalamount(Customer.getTotalamount());
							dao.save(c);
							return;
						}
					}
					throw new CustomreNotFoundException();	//customer id not found
	}

	@Override
	public void removeCustomer(long customer_id) throws CustomreNotFoundException {
		AdminList = admindao.findAll();
		CustomerList = dao.findAll();
		for(Customer od : CustomerList) {
			if(od.getId() == customer_id) {
				cartList = cartdao.findAll();
				for(Cart c : cartList) {
					if(c.getCustomer().getId() == customer_id) {
						c.setPlant(null);
						c.setPlanter(null);
						c.setFertilizer(null);
						c.setSeed(null);
						c.setGardendecor(null);
						cartdao.save(c);
						cartdao.delete(c);
					}
				}
				
				//dao.deleteById( customer_id);
				return;
			}
		}
		throw new CustomreNotFoundException();	//customer id not found
	}

	@Override
	public List<Customer> getAllCustomer() throws ListIsEmptyException, NotAuthorizedException {
		CustomerList = dao.findAll();
		//if(admindao.existsById(adminID)) {
			if(CustomerList.isEmpty()) {
				throw new ListIsEmptyException();
			}
			return CustomerList;
		//}
		//throw new NotAuthorizedException();	//only admin have access to this 
	}

	@Override
	public Customer getCustomerById(long customer_id) throws IDNotFoundException {
		if(dao.existsById(customer_id)) {
			return dao.getCustomerById(customer_id);
		}
		throw new IDNotFoundException();
	}

	
}