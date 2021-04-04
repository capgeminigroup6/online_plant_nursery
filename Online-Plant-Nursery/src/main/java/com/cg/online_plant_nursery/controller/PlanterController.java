package com.cg.online_plant_nursery.controller;

@RestController
@RequestMapping("/planter")
public class PlanterController {
	@Autowired
	IPlanterService service;
	
	@PostMapping("/addplanter")
	 public ResponseEntity<String> addPlanter(@RequestBody Planter planter){
	  service.addPlanter(planter);
	  return new ResponseEntity<String>("Planter Added",HttpStatus.OK);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Planter>> getAllPlanters(){
	  List<Planter> planterList=service.getAllPlanters();
	  return new ResponseEntity<List<Planter>>(planterList,HttpStatus.OK);
	 }
	
	 @GetMapping("/getbyid")
	 public ResponseEntity<Planter> getPlanterById(@RequestBody int Id){
	 Planter planter=service.getPlanterById(Id);
	  return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{PlanterId}")
		public ResponseEntity<String> removePlanter(@PathVariable int PlanterId){
			service.removePlanter(PlanterId);
			return new ResponseEntity<String>("deleted...", HttpStatus.OK);
		}
	 @PutMapping("/updateplanter/{id}")
	 public ResponseEntity<String> updatePlanter(@PathVariable int id,@RequestBody Planter planter){
	  service.updatePlanter(id, planter);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	 }

}
