package com.cg.online_plant_nursery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.online_plant_nursery.dao.CustomerDAO;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.utils.CustomreNotFoundException;
import com.cg.online_plant_nursery.utils.DuplicateOrderException;
import com.cg.online_plant_nursery.utils.IDNotFoundException;
import com.cg.online_plant_nursery.utils.ListIsEmptyException;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	CustomerDAO dao;
	@Autowired
	CustomerDAO customerdao;
	List<Customer> CustomerList = new ArrayList<>();
	List<Customer> customerList = new ArrayList<>();
	
	@Override
	public void addCustomer(Customer Customer) throws DuplicateOrderException {
		CustomerList = dao.findAll();
		for(Customer od : CustomerList) {
			if(od.getId() == Customer.getId()) {
				throw new DuplicateOrderException();
			}
		}
		dao.save(Customer);
	}

	@Override
	public void updateCustomer(long OrderId, Customer Customer)
			throws CustomreNotFoundException {
		CustomerList = dao.findAll();
		for(Customer od : CustomerList) {
			if(od.getId() == OrderId) {
				customerList = customerdao.findAll();
					for(Customer c : customerList) {
						if(c.getId() == Customer.getId()) {
							od.setId(Customer.getId());
							od.setName(Customer.getName());
							od.setEmail(Customer.getEmail());
							od.setPassword(Customer.getPassword());
							od.setContactnumber(Customer.getContactnumber());
							od.setTotalamount(Customer.getTotalamount());
							dao.save(od);
							return;
						}
					}
					throw new CustomreNotFoundException();
			}
		}
		throw new CustomreNotFoundException();
	}

	@Override
	public void removeCustomer(long OrderId) throws CustomreNotFoundException {
		CustomerList = dao.findAll();
		for(Customer od : CustomerList) {
			if(od.getId() == OrderId) {
				dao.deleteById( OrderId);
				return;
			}
		}
		throw new CustomreNotFoundException();
	}

	@Override
	public List<Customer> getAllCustomer() throws ListIsEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(long customer_id) throws IDNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}