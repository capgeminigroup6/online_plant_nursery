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
	
	@GetMapping("/get/{admin}")
	public ResponseEntity<List<Cart>> viewCart(@PathVariable long admin){
		return new ResponseEntity<List<Cart>>(service.viewCart(admin), HttpStatus.OK);
	}
	@GetMapping("/getOne/{customerID}")
	public ResponseEntity<Cart> viewOneCart(@PathVariable long customerID){
		return new ResponseEntity<Cart>(service.getOneCart(customerID), HttpStatus.OK);
	}
	@GetMapping("/TotalCartAmount/{customerID}")
	public ResponseEntity<String> getCartAmt(@PathVariable long customerID){
		double amt = service.TotalCartAmount(customerID);
		return new ResponseEntity<String>("CustomerID: "+customerID+", totalCartAmount: "+amt, HttpStatus.OK);
	}
	
	@PostMapping("/addPlant")
	public ResponseEntity<String> addPlantToCart(@RequestParam long customerID,long plantID,int quantity){
		service.addPlantToCart(customerID, plantID, quantity);
		return new ResponseEntity<String>("plant added...", HttpStatus.OK);
	}
	@PostMapping("/addSeed")
	public ResponseEntity<String> addSeedToCart(@RequestParam long customerID,long seedID,int quantity){
		service.addSeedToCart(customerID, seedID, quantity);
		return new ResponseEntity<String>("seed added...", HttpStatus.OK);
	}
	@PostMapping("/addPlanter")
	public ResponseEntity<String> addPlanterToCart(@RequestParam long customerID,long planterID,int quantity){
		service.addPlanterToCart(customerID, planterID, quantity);
		return new ResponseEntity<String>("Planter added...", HttpStatus.OK);
	}
	@PostMapping("/addDecor")
	public ResponseEntity<String> addDecorToCart(@RequestParam long customerID,long decorID,int quantity){
		service.addGardenDecorToCart(customerID, decorID, quantity);
		return new ResponseEntity<String>("Decor added...", HttpStatus.OK);
	}
	@PostMapping("/addFertilizer")
	public ResponseEntity<String> addFerilizerToCart(@RequestParam long customerID,long fertilizerID,int quantity){
		service.addFertilizerToCart(customerID, fertilizerID, quantity);
		return new ResponseEntity<String>("fertilizers added...", HttpStatus.OK);
	}
	
	@DeleteMapping("/delPlant")
	public ResponseEntity<String> deletePlant(@RequestParam long customerID,long plantID){
		service.removePlantFromCart(customerID, plantID);
		return new ResponseEntity<String>("plant deleted...", HttpStatus.OK);
	}
	@DeleteMapping("/delSeed")
	public ResponseEntity<String> deleteSeed(@RequestParam long customerID,long seedID){
		service.removeSeedFromCart(customerID, seedID);
		return new ResponseEntity<String>("seed deleted...", HttpStatus.OK);
	}
	@DeleteMapping("/delPlanter")
	public ResponseEntity<String> deletePlanter(@RequestParam long customerID,long planterID){
		service.removePlanterFromCart(customerID, planterID);
		return new ResponseEntity<String>("planter deleted...", HttpStatus.OK);
	}
	@DeleteMapping("/delDecor")
	public ResponseEntity<String> deleteGardenDecor(@RequestParam long customerID,long GardenDecorID){
		service.removeGardenDecorFromCart(customerID, GardenDecorID);
		return new ResponseEntity<String>("GardenDecor deleted...", HttpStatus.OK);
	}
	@DeleteMapping("/delFertilizer")
	public ResponseEntity<String> deleteFertilizer(@RequestParam long customerID,long FertilizerID){
		service.removeFertilizerFromCart(customerID, FertilizerID);
		return new ResponseEntity<String>("Fertilizer deleted...", HttpStatus.OK);
	}
	
	@PutMapping("/updatePlant")
	public ResponseEntity<String> updatePlant(@RequestParam long customerID,long plantID,int quantity){
		service.updatePlantQuantity(customerID, plantID, quantity);
		return new ResponseEntity<String>("Plant updated ...", HttpStatus.OK);
	}
	@PutMapping("/updateSeed")
	public ResponseEntity<String> updateSeed(@RequestParam long customerID,long seedID,int quantity){
		service.updateSeedQuantity(customerID, seedID, quantity);
		return new ResponseEntity<String>("Seed updated ...", HttpStatus.OK);
	}
	@PutMapping("/updatePlanter")
	public ResponseEntity<String> updatePlanter(@RequestParam long customerID,long planterID,int quantity){
		service.updatePlanterQuantity(customerID, planterID, quantity);
		return new ResponseEntity<String>("Planter updated ...", HttpStatus.OK);
	}
	@PutMapping("/updateDecor")
	public ResponseEntity<String> updateDecor(@RequestParam long customerID,long DecorID,int quantity){
		service.updateGardenDecorQuantity(customerID, DecorID, quantity);
		return new ResponseEntity<String>("Garder Decor updated ...", HttpStatus.OK);
	}
	@PutMapping("/updateFertilizer")
	public ResponseEntity<String> updateFertilizer(@RequestParam long customerID,long FertilizerID,int quantity){
		service.updateFertilizerQuantity(customerID, FertilizerID, quantity);
		return new ResponseEntity<String>("Fertilizer updated ...", HttpStatus.OK);
	}
	
	
	
}
