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

import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.services.ISeedService;
import com.cg.online_plant_nursery.services.SeedServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/seed")
public class SeedController {
@Autowired
SeedServiceImpl service;

@PostMapping("/add")
public ResponseEntity<String> addSeed(@RequestBody Seed seed){
 service.addSeed(seed);
 return new ResponseEntity<String>("Seed Added",HttpStatus.OK);
}

@GetMapping("/getAll")
public ResponseEntity<List<Seed>> getAllSeeds(){
 List<Seed> seedList=service.getAllSeeds();
 return new ResponseEntity<List<Seed>>(seedList,HttpStatus.OK);
}

@GetMapping("/getbyid")
public ResponseEntity<Seed> getSeedById(@RequestParam int Id){
Seed seed=service.getSeedById(Id);
 return new ResponseEntity<Seed>(seed,HttpStatus.OK);
}

@DeleteMapping("/deleteseed/{Id}")
public ResponseEntity<String> removeSeed(@PathVariable ("Id")int Id){
service.removeSeed(Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}
@PutMapping("/updateseed")
public ResponseEntity<String> updateSeed(@RequestParam int id,@RequestBody Seed seed){
 service.updateSeed(id, seed);
 return new ResponseEntity<String>("updated",HttpStatus.OK);
}
}
