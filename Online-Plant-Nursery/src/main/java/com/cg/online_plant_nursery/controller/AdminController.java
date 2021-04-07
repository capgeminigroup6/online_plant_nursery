package com.cg.online_plant_nursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.online_plant_nursery.entity.Admin;
import com.cg.online_plant_nursery.services.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
AdminServiceImpl service;		

@PostMapping("/add/{adminID}")
public ResponseEntity<String> addadmin(@PathVariable long adminID,@RequestBody Admin admin){
 service.addAdmin(adminID,admin);
 return new ResponseEntity<String>("Admin Added",HttpStatus.OK);
}

@GetMapping ("/get/{adminID}")
public ResponseEntity<List<Admin>> getAllAdmin(@PathVariable long adminID){
 List<Admin> adminList=service.getAllAdmin(adminID);
 return new ResponseEntity<List<Admin>>(adminList,HttpStatus.OK);
}

@GetMapping("/getbyid/{adminID}")
public ResponseEntity<Admin> getAdminById(@PathVariable long adminID,@RequestParam int id){
 Admin admin=service.getAdminById(adminID,id);
 return new ResponseEntity<Admin>(admin,HttpStatus.OK);
}

@DeleteMapping("/delete/{adminID}")
public ResponseEntity<String> removeAdmin(@PathVariable long adminID,@RequestParam int Id){
service.removeAdmin(adminID,Id);
return new ResponseEntity<String>("deleted...", HttpStatus.OK);
}
}
