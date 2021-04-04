package com.cg.online_plant_nursery.controller;


@RestController
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	IPlantService service;
	
	@PostMapping("/addplant")
	 public ResponseEntity<String> addPlant(@RequestBody Plant plant){
	  service.addPlant(plant);
	  return new ResponseEntity<String>("Plant Added",HttpStatus.OK);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Plant>> getAllPlants(){
	  List<Plant> plantList=service.getAllPlants();
	  return new ResponseEntity<List<Plant>>(plantList,HttpStatus.OK);
	 }
	
	 @GetMapping("/getbyid")
	 public ResponseEntity<Plant> getPlantById(@RequestBody int Id){
	 Plant plant=service.getPlantById(Id);
	  return new ResponseEntity<Plant>(plant,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{PlantId}")
		public ResponseEntity<String> removePlant(@PathVariable int PlantId){
			service.removePlant(PlantId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 @PutMapping("/updateplant/{id}")
	 public ResponseEntity<String> updatePlant(@PathVariable int id,@RequestBody Plant plant){
	  service.updatePlant(id, plant);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }
	 

}
