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

import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.services.IPlantService;

@RestController
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	IPlantService service;
	
	@PostMapping("/addplant")
	 public ResponseEntity<String> addPlant(@RequestBody Plant plant){
	  service.addPlant(plant);
	  return new ResponseEntity<String>("Plant Added",HttpStatus.OK);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Plant>> getAllPlants(){
	  List<Plant> plantList=service.getAllPlants();
	  return new ResponseEntity<List<Plant>>(plantList,HttpStatus.OK);
	 }
	
	 @GetMapping("/getbyid")
	 public ResponseEntity<Plant> getPlantById(@RequestBody int Id){
	 Plant plant=service.getPlantById(Id);
	  return new ResponseEntity<Plant>(plant,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{PlantId}")
		public ResponseEntity<String> removePlant(@PathVariable int PlantId){
			service.removePlant(PlantId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 @PutMapping("/updateplant/{id}")
	 public ResponseEntity<String> updatePlant(@PathVariable int id,@RequestBody Plant plant){
	  service.updatePlant(id, plant);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }
	 

}
