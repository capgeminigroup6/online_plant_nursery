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

import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.services.IPlanterService;

@RestController
@RequestMapping("/planter")
public class PlanterController {
	@Autowired
	IPlanterService service;
	
	@PostMapping("/addplanter")
	 public ResponseEntity<String> addPlanter(@RequestBody Planter planter){
	  service.addPlanter(planter);
	  return new ResponseEntity<String>("Planter Added",HttpStatus.OK);
	 }
	
	 @GetMapping("/getAll")
	 public ResponseEntity<List<Planter>> getAllPlanters(){
	  List<Planter> planterList=service.getAllPlanters();
	  return new ResponseEntity<List<Planter>>(planterList,HttpStatus.OK);
	 }
	
	 @GetMapping("/getbyid")
	 public ResponseEntity<Planter> getPlanterById(@RequestBody int Id){
	 Planter planter=service.getPlanterById(Id);
	  return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{PlanterId}")
		public ResponseEntity<String> removePlanter(@PathVariable int PlanterId){
			service.removePlanter(PlanterId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 
	 @PutMapping("/updateplanter/{id}")
	 public ResponseEntity<String> updatePlanter(@PathVariable int id,@RequestBody Planter planter){
	  service.updatePlanter(id, planter);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }

}
