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

import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.services.FertilizerServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RestController  
@RequestMapping("/fertilizer")
public class FertilizerController{
	@Autowired
	FertilizerServiceImpl service;

	@PostMapping
	public ResponseEntity<String> addFertilizer( @RequestBody Fertilizer fertilizer){
		service.addFertilizer( fertilizer);
		return new ResponseEntity<String>("fertilizer added...", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
		return new ResponseEntity<List<Fertilizer>>(service.getAllFertilizers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{fertilizerID}")
	public ResponseEntity<String> removeFertilizer(@PathVariable("fertilizerID")int fertilizerID){
		service.removeFertilizer(fertilizerID);
		return new ResponseEntity<String>("deleted...", HttpStatus.OK);
	}
	@GetMapping("/getbyid")
	 public ResponseEntity<Fertilizer> getFertilizerById(@RequestBody int Id){
	 Fertilizer fertilizer=service.getFertilizerById(Id);
	  return new ResponseEntity<Fertilizer>(fertilizer,HttpStatus.OK);
	 }
	 @PutMapping("/updatefertilizer")
	 public ResponseEntity<String> updateFertilizer(@RequestParam int id,@RequestBody Fertilizer fertilizer){
	  service.updateFertilizer( id, fertilizer);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }
}



