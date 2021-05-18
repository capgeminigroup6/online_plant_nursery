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

import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.services.IPlanterService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/planter")
public class PlanterController {
	@Autowired
	IPlanterService service;
	
	@PostMapping
	 public ResponseEntity<String> addPlanter(@RequestBody Planter planter){
	  service.addPlanter(planter);
	  return new ResponseEntity<String>("Planter Added",HttpStatus.OK);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Planter>> getAllPlanters(){
	  List<Planter> planterList=service.getAllPlanters();
	  return new ResponseEntity<List<Planter>>(planterList,HttpStatus.OK);
	 }
	
	 @GetMapping("/getbyid")
	 public ResponseEntity<Planter> getPlanterById(@RequestBody int id){
	 Planter planter=service.getPlanterById(id);
	  return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{planterId}")
		public ResponseEntity<String> removePlanter(@PathVariable int planterId){
			service.deletePlanter(planterId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 
	 @PutMapping("/updateplanter")
	 public ResponseEntity<String> updatePlanter(@RequestParam int id,@RequestBody Planter planter){
	  service.updatePlanter(id, planter);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }

}
