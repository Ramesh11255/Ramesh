package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.TouristService;

@RestController
@RequestMapping("/tourist-api")
public class TouristController {

	@Autowired
	private TouristService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist) {
		try {
			String msg = service.registerTourist(tourist);

			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> showAllTourist() {
		try {
			List<Tourist> list=service.showAllTourist();
			
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/report/{start}/{end}")
	public ResponseEntity<?> searchTouristByBudgetRange(@PathVariable double start,@PathVariable double  end) {
		try {
			List<Tourist> list=service.serachByBudgetRange(start, end);
			
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> showTouristById(@PathVariable int id) {
		try {
			Tourist msg=service.showTouristById(id);
			
			return new ResponseEntity<Tourist>(msg, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
		try {
			String msg=service.updateTourist(tourist);
			
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/pupdate/{id}/{percentage}")
	public ResponseEntity<String> updateTourist(@PathVariable int id,@PathVariable float percentage) {
		try {
			String msg=service.updateTouristBudget(id, percentage);
			
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable int id) {
		try {
			String msg=service.removeTouritByid(id);
			
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{type}")
	public ResponseEntity<String> removeTouristByPackageType(@PathVariable String type) {
		try {
			String msg=service.removeTouritByPackageType(type);
			
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
