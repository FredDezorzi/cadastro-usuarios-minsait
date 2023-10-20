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

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.services.SucessMessage;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;
	
    // Method to retrieve all users, using the DTO entity
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
    // Method to retrieve a user by ID, without using the DTO entity
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Method to delete a user by ID, without using the DTO entity
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SucessMessage>delete(@PathVariable Long id) throws ResourceNotFoundException{
		service.delete(id);
		SucessMessage message = new SucessMessage("User " + id + " successfully deleted");
		return ResponseEntity.ok(message);
	}
	
    // Method to insert a new user, having a DTO entity as return
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		UserDTO objDto = UserDTO.convertToDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	// Method to update a user by ID, having a DTO entity as return
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> insert(@RequestBody User obj, @PathVariable Long id) {
		obj = service.update(obj, id);
		UserDTO objDto = UserDTO.convertToDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
}
