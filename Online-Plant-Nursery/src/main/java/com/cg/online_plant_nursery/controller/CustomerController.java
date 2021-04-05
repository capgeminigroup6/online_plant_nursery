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
import com.cg.online_plant_nursery.services.ICustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
@Autowired
CustomerServiceImpl service;

@PostMapping("/addcustomer")
public ResponseEntity<String> addcustomer(@RequestBody Customer customer){
 service.addCustomer(customer);
 return new ResponseEntity<String>("Customer Added",HttpStatus.OK);
}

@GetMapping("/get")
public ResponseEntity<List<Customer>> getAllCustomer(){
 List<Customer> customerList=service.getAllCustomer();
 return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
}

@GetMapping("/getbyid")
public ResponseEntity<Customer> getCustomerById(@RequestBody int Id){
 Customer customer=service.getCustomerById(Id);
 return new ResponseEntity<Customer>(customer,HttpStatus.OK);
}

@DeleteMapping("/delete/{Id}")
public ResponseEntity<String> removeCustomer(@PathVariable int Id){
service.removeCustomer(Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}

@PutMapping("/updateCustomer/{id}")
public ResponseEntity<String> updateCustomer(@PathVariable int id,@RequestBody Customer customer){
 service.updateCustomer(id, customer);
 return new ResponseEntity<String>("updated",HttpStatus.OK);
}
}
