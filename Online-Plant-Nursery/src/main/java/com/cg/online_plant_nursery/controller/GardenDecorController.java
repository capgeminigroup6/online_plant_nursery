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

import com.cg.online_plant_nursery.entity.GardenDecor;
import com.cg.online_plant_nursery.services.IGardenDecorService;

@RestController
@RequestMapping("/gardendecor")
public class GardenDecorController {
@Autowired
IGardenDecorService service;

@PostMapping("/addgardendecor/{admin}")
public ResponseEntity<String> addDecor(@PathVariable long admin,@RequestBody GardenDecor decor){
 service.addDecor(admin, decor);
 return new ResponseEntity<String>("GardenDecor Added",HttpStatus.OK);
}

@GetMapping("/getAll")
public ResponseEntity<List<GardenDecor>> getAllDecors(){
 List<GardenDecor> decorList=service.getAllDecors();
 return new ResponseEntity<List<GardenDecor>>(decorList,HttpStatus.OK);
}

@GetMapping("/getbyid")
public ResponseEntity<GardenDecor> getDecorById(@RequestParam int Id){
GardenDecor decor=service.getDecorById(Id);
 return new ResponseEntity<GardenDecor>(decor,HttpStatus.OK);
}

@DeleteMapping("/delete/{admin}")
public ResponseEntity<String> removeDecor(@PathVariable long admin, @RequestParam int Id){
service.removeDecor(admin, Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}
@PutMapping("/updategardendecor/{admin}")
public ResponseEntity<String> updateDecor(@PathVariable long admin,@RequestParam int id,@RequestBody GardenDecor decor){
 service.updateGardenDecor(admin,id, decor);
 return new ResponseEntity<String>("updated",HttpStatus.OK);
}
}
