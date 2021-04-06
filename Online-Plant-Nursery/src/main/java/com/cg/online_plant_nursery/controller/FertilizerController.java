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

import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.services.FertilizerServiceImpl;
import com.cg.online_plant_nursery.services.IFertilizerService;
import com.cg.online_plant_nursery.utils.DuplicateException;

@RestController  
@RequestMapping("/Fertilizer")
public class FertilizerController{
	@Autowired
	FertilizerServiceImpl service;

	@PostMapping("/add/{admin}")
	public ResponseEntity<String> addFertilizer(@PathVariable long admin, @RequestBody Fertilizer fertilizer){
		service.addFertilizer(admin, fertilizer);
		return new ResponseEntity<String>("fertilizer added...", HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Fertilizer>> getAllFertilizers(){
		return new ResponseEntity<List<Fertilizer>>(service.getAllFertilizers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{admin}")
	public ResponseEntity<String> removeFertilizer(@PathVariable long admin, @RequestParam int fertilizerID){
		service.removeFertilizer(admin,fertilizerID);
		return new ResponseEntity<String>("deleted...", HttpStatus.OK);
	}
	@GetMapping("/getbyid")
	 public ResponseEntity<Fertilizer> getFertilizerById(@RequestBody int Id){
	 Fertilizer fertilizer=service.getFertilizerById(Id);
	  return new ResponseEntity<Fertilizer>(fertilizer,HttpStatus.OK);
	 }
	 @PutMapping("/updatefertilizer/{admin}")
	 public ResponseEntity<String> updateFertilizer(@PathVariable long admin,@RequestParam int id,@RequestBody Fertilizer fertilizer){
	  service.updateFertilizer(admin, id, fertilizer);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }
}



