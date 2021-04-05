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

import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.services.IGardenDecorService;

@RestController
@RequestMapping("/gardendecor")
public class GardenDecorController {
@Autowired
IGardenDecorService service;

@PostMapping("/addgardendecor")
public ResponseEntity<String> addDecor(@RequestBody GardenDecor decor){
 service.addDecor(decor);
 return new ResponseEntity<String>("GardenDecor Added",HttpStatus.OK);
}

@GetMapping
public ResponseEntity<List<GardenDecor>> getAllDecors(){
 List<GardenDecor> decorList=service.getAllDecors();
 return new ResponseEntity<List<GardenDecor>>(decorList,HttpStatus.OK);
}

@GetMapping("/getbyid")
public ResponseEntity<GardenDecor> getDecorById(@RequestBody int Id){
GardenDecor decor=service.getDecorById(Id);
 return new ResponseEntity<GardenDecor>(decor,HttpStatus.OK);
}

@DeleteMapping("/delete/{Id}")
public ResponseEntity<String> removeDecor(@PathVariable int Id){
service.removeDecor(Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}
@PutMapping("/updategardendecor/{id}")
public ResponseEntity<String> updateDecor(@PathVariable int id,@RequestBody GardenDecor decor){
 service.updateGardenDecor(id, decor);
 return new ResponseEntity<String>("updated",HttpStatus.OK);
}
}
