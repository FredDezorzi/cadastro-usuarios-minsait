package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return this.repository.findAll();
	}
	
	public User insert(User obj) {
		return this.repository.save(obj);
	}
	
	public User findById(Long id){
		try {
			return this.repository.findById(id).get();
		}catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@Transactional
	public void delete(Long id){
		try{
			this.repository.deleteById(id);
		}catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
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
