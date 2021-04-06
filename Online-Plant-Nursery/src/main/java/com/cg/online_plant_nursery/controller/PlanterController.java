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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.online_plant_nursery.entity.Planter;
import com.cg.online_plant_nursery.services.IPlanterService;

@RestController
@RequestMapping("/planter")
public class PlanterController {
	@Autowired
	IPlanterService service;
	
	@PostMapping("/addplanter/{admin}")
	 public ResponseEntity<String> addPlanter(@PathVariable long admin,@RequestBody Planter planter){
	  service.addPlanter(admin,planter);
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
	 
	 @DeleteMapping("/delete/{admin}")
		public ResponseEntity<String> removePlanter(@PathVariable long admin,@RequestParam int PlanterId){
			service.removePlanter(admin,PlanterId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 
	 @PutMapping("/updateplanter/{admin}")
	 public ResponseEntity<String> updatePlanter(@PathVariable long admin,@RequestParam int id,@RequestBody Planter planter){
	  service.updatePlanter(admin,id, planter);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }

}
