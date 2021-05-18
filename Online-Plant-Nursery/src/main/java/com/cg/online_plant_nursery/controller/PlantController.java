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

import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.services.IPlantService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	IPlantService service;
	
	@PostMapping
	 public ResponseEntity<String> addPlant(@RequestBody Plant plant){
	  service.addPlant(plant);
	  return new ResponseEntity<String>("Plant Added",HttpStatus.OK);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Plant>> getAllPlants(){
	  List<Plant> plantList=service.getAllPlants();
	  return new ResponseEntity<List<Plant>>(plantList,HttpStatus.OK);
	 }
	
	 @GetMapping("/getbyid/{plantId}")
	 public ResponseEntity<Plant> getPlantById(@PathVariable int plantId){
	 Plant plant=service.getPlantById(plantId);
	  return new ResponseEntity<Plant>(plant,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{plantId}")
		public ResponseEntity<String> removePlant(@PathVariable("plantId") int plantId){
			service.deletePlant(plantId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 
	 @PutMapping("/updateplant")
	 public ResponseEntity<String> updatePlant(@RequestParam int id,@RequestBody Plant plant){
	  service.updatePlant(id, plant);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }
	 

}
