//package com.cg.online_plant_nursery.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.online_plant_nursery.entity.Admin;
//import com.cg.online_plant_nursery.services.AdminServiceImpl;
//import com.cg.online_plant_nursery.services.IAdminService;
//
//@RestController
//@RequestMapping("/")
//public class AdminController {
//@Autowired
//AdminServiceImpl service;
//
//@PostMapping("/addadmin")
//public ResponseEntity<String> addadmin(@RequestBody Admin admin){
// service.addAmin(admin);
// return new ResponseEntity<String>("Admin Added",HttpStatus.OK);
//}
//
//@GetMapping public ResponseEntity<List<Admin>> getAllAdmin(){
// List<Admin> adminList=service.getAllAdmin();
// return new ResponseEntity<List<Admin>>(adminList,HttpStatus.OK);
//}
//
//@GetMapping("/getbyid")
//public ResponseEntity<Admin> getAdminById(@RequestBody int Id){
// Admin admin=service.getAdminById(Id);
// return new ResponseEntity<Admin>(admin,HttpStatus.OK);
//}
//
//@DeleteMapping("/delete/{Id}")
//public ResponseEntity<String> removeAdmin(@PathVariable int Id){
//service.removeAdmin(Id);
//return new ResponseEntity<String>("deleted...", HttpStatus.OK);
//}
//}
