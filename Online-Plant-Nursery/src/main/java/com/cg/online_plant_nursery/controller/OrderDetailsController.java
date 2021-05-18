package com.cg.online_plant_nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.online_plant_nursery.entity.OrderDetails;
import com.cg.online_plant_nursery.services.OrderDetailsServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {
	@Autowired
	OrderDetailsServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrderDetails(@RequestParam long customerID,String paymentOp,String shipping_address){
		service.addOrderDetails(customerID,paymentOp,shipping_address);
		return new ResponseEntity<String>("order added...",HttpStatus.OK);
	}
	
	@PutMapping("/update/{orderID}")
	public ResponseEntity<String> updateOrderDetails(@PathVariable long orderID, @RequestBody OrderDetails orderDetails){
		service.updateOrderDetails(orderID, orderDetails);
		return new ResponseEntity<String>("updated...", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{orderID}")
	public ResponseEntity<String> deleteOrderDetails(@PathVariable long orderID){
		service.deleteOrderDetails(orderID);
		return new ResponseEntity<String>("deleted...",HttpStatus.OK);
	}
	
	@GetMapping("/getAll/{adminID}")
	public ResponseEntity<List<OrderDetails>> getAllOrderDetails(@PathVariable long adminID){
		return new ResponseEntity<List<OrderDetails>>(service.getAllOrderDetails(adminID),HttpStatus.OK);
	}
	
	@GetMapping("/getByID/{customerID}")
	public ResponseEntity<List<OrderDetails>> getOrderDetailsById(@PathVariable long customerID) {
		return new ResponseEntity<List<OrderDetails>>(service.getOrderDetailsById(customerID), HttpStatus.OK);
	}
}
