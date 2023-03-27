package com.practica.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practica.exceptions.ResourceNotFoundException;
import com.practica.model.Servicio;
import com.practica.service.ServicioService;

@RestController
@RequestMapping("services")
@CrossOrigin
public class ServicioRestController {

	@Autowired
	private ServicioService servicioService;
    //List of all services
	@CrossOrigin
	@GetMapping(path = "/get-all", produces = "application/json")
	public ResponseEntity<List<Servicio>> getServices() {
		List<Servicio> serviciosList = this.servicioService.getServices();
		return ResponseEntity.ok(serviciosList);
	}
	//Get services by tag
	@CrossOrigin
	@GetMapping(path = "/tag/{tag}", produces = "application/json")
	public ResponseEntity<List<Servicio>> getServicesByTagName(@PathVariable("tag") String tag) {
		List<Servicio> serviciosList = this.servicioService.getServicesByTagName(tag);
		return ResponseEntity.ok(serviciosList);
	}
	//Get services by category
	@CrossOrigin
	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ResponseEntity<List<Servicio>> getServicesByCategory(@PathVariable("category") String category) {
		List<Servicio> serviciosList = this.servicioService.getServicesByCategory(category);
		return ResponseEntity.ok(serviciosList);
	}
	//New Service
	@CrossOrigin
	@PostMapping("/new")
	public ResponseEntity<Servicio> saveService(@RequestBody Servicio service) {
		Servicio savedService = this.servicioService.saveService(service);
		return new ResponseEntity<Servicio>(savedService, HttpStatus.CREATED);
	}
	//Update Service
	@CrossOrigin
	@PutMapping("/update/id/{id}")
	public ResponseEntity<Servicio> updateServicio(
			@RequestBody Servicio service, 
			@PathVariable("id") int id) 
			throws ResourceNotFoundException {
		service.setId(id);
		Servicio updatedService = this.servicioService.updateServicio(service);
		return new ResponseEntity<Servicio>(updatedService, HttpStatus.OK);
	}
	//Delete Service
	@DeleteMapping("/delete/id/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteStudent(@PathVariable int id) throws ResourceNotFoundException{
		this.servicioService.deleteServiceById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.CREATED);
	}
	
}
