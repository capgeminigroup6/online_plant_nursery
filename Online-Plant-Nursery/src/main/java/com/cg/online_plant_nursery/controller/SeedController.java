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

import com.cg.online_plant_nursery.entity.Seed;
import com.cg.online_plant_nursery.services.ISeedService;

@RestController
@RequestMapping("/seed")
public class SeedController {
@Autowired
ISeedService service;

@PostMapping("/addseed")
public ResponseEntity<String> addSeed(@RequestBody Seed seed){
 service.addSeed(seed);
 return new ResponseEntity<String>("Seed Added",HttpStatus.OK);
}

@GetMapping
public ResponseEntity<List<Seed>> getAllSeeds(){
 List<Seed> seedList=service.getAllSeeds();
 return new ResponseEntity<List<Seed>>(seedList,HttpStatus.OK);
}

@GetMapping("/getbyid")
public ResponseEntity<Seed> getSeedById(@RequestBody int Id){
Seed seed=service.getSeedById(Id);
 return new ResponseEntity<Seed>(seed,HttpStatus.OK);
}

@DeleteMapping("/delete/{Id}")
public ResponseEntity<String> removeSeed(@PathVariable int Id){
service.removeSeed(Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}
@PutMapping("/updateseed/{id}")
public ResponseEntity<String> updateSeed(@PathVariable int id,@RequestBody Seed seed){
 service.updateSeed(id, seed);
 return new ResponseEntity<String>("updated",HttpStatus.OK);
}
}
