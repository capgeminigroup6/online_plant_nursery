package com.cg.online_plant_nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.services.CustomerServiceImpl;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
@Autowired
CustomerServiceImpl service;

@PostMapping("/validate")
public ResponseEntity<Customer> validate(@RequestBody Customer customer){
	Customer cust = service.validate(customer.getEmail(),customer.getPassword());
	return new ResponseEntity<Customer>(cust,HttpStatus.OK);
}

@PostMapping("/addcustomer")
public ResponseEntity<String> addcustomer(@RequestBody Customer customer){
 service.addCustomer(customer);
 return new ResponseEntity<String>("Customer Added",HttpStatus.OK);
}

@GetMapping("/get/{adminID}")
public ResponseEntity<List<Customer>> getAllCustomer(@PathVariable long adminID){
 return new ResponseEntity<List<Customer>>(service.getAllCustomer(adminID),HttpStatus.OK);
}

@GetMapping("/getbyid/{Id}")
public ResponseEntity<Customer> getCustomerById(@PathVariable long Id){
 return new ResponseEntity<Customer>(service.getCustomerById(Id),HttpStatus.OK);
}

@DeleteMapping("/delete/{Id}")
public ResponseEntity<String> removeCustomer(@PathVariable long Id){
service.removeCustomer(Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}

@PutMapping("/updateCustomer/{id}")
public ResponseEntity<String> updateCustomer(@PathVariable long id,@RequestBody Customer customer){
 service.updateCustomer(id, customer);
 return new ResponseEntity<String>("updated...",HttpStatus.OK);
}
}
