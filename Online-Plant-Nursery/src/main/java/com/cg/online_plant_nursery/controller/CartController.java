package com.cg.online_plant_nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.services.CartServiceImpl;

@RestController
@RequestMapping("/Cart")
public class CartController {
	@Autowired
	CartServiceImpl service;
	
	@GetMapping("/get")
	public ResponseEntity<List<Cart>> viewCart(){
		return new ResponseEntity<List<Cart>>(service.viewCart(), HttpStatus.OK);
	}
	
//	@PostMapping("/addPlant")
//	public ResponseEntity<String> addPlantToCart(@RequestParam long customerID,long plantID,int quantity){
//		service.addPlantToCart(customerID, plantID, quantity);
//		return new ResponseEntity<String>("plant added...", HttpStatus.OK);
//	}
//	@PostMapping("/addSeed")
//	public ResponseEntity<String> addSeedToCart(@RequestParam long customerID,long seedID,int quantity){
//		service.addSeedToCart(customerID, seedID, quantity);
//		return new ResponseEntity<String>("seed added...", HttpStatus.OK);
//	}
//	@PostMapping("/addPlanter")
//	public ResponseEntity<String> addPlanterToCart(@RequestParam long customerID,long planterID,int quantity){
//		service.addPlanterToCart(customerID, planterID, quantity);
//		return new ResponseEntity<String>("Planter added...", HttpStatus.OK);
//	}
//	@PostMapping("/addDecor")
//	public ResponseEntity<String> addDecorToCart(@RequestParam long customerID,long decorID,int quantity){
//		service.addGardenDecorToCart(customerID, decorID, quantity);
//		return new ResponseEntity<String>("Decor added...", HttpStatus.OK);
//	}
//	@PostMapping("/addFertilizer")
//	public ResponseEntity<String> addFerilizerToCart(@RequestParam long customerID,long fertilizerID,int quantity){
//		service.addFertilizerToCart(customerID, fertilizerID, quantity);
//		return new ResponseEntity<String>("fertilizers added...", HttpStatus.OK);
//	}
	
	
}
