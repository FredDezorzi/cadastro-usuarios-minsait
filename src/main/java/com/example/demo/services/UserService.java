package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
    // Method to retrieve a list of UserDTO objects.
	public List<UserDTO> findAll(){
		List<User> objs = new ArrayList<>();
		objs = this.repository.findAll();
		List<UserDTO> dtos = new ArrayList<>();

        for (User obj : objs) {
        	UserDTO objDto = new UserDTO(obj.getName(), obj.getEmail(), obj.getBirthDay());
            dtos.add(objDto);
        }
		return dtos;
	}
	
    // Method to insert a new User object.
	public User insert(User obj) {
		return this.repository.save(obj);
	}
	
    // Method to find a User by ID.
	public User findById(Long id){
		try {
			return this.repository.findById(id).get();
		}catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
    // Method to delete a User by ID.
	@Transactional
	public void delete(Long id){
		try{
			this.repository.deleteById(id);
		}catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
    // Method to update a User by ID.
	public User update(User obj, Long id) {
		try {
			User entity = repository.getReferenceById(id);
			entity.setName(obj.getName());
			entity.setEmail(obj.getEmail());
			entity.setPassword(obj.getPassword());
			entity.setBirthDay(obj.getBirthDay());
			return repository.save(entity);
		}catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}

	}
	
}
