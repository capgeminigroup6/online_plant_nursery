package com.cg.online_plant_nursery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.online_plant_nursery.services.CartServiceImpl;

@RestController
@RequestMapping("/Cart")
public class CartController {
	@Autowired
	CartServiceImpl service;
	
	@PostMapping("/add/{customerID}")
	public ResponseEntity<String> addPlantToCart(@PathVariable long customerID, @RequestParam long plantID,int quantity){
		service.addPlantToCart(customerID, plantID, quantity);
		return new ResponseEntity<String>("plant added...", HttpStatus.OK);
	}
}
