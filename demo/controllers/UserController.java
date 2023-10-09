package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().body("User " + id + " successfully deleted");
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> insert(@RequestBody User obj, @PathVariable Long id) {
		obj = service.update(obj, id);
		return ResponseEntity.ok().body(obj);
	}
}
