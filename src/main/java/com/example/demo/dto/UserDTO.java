package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
	
	// Fields for userDTO data
	private String name;
	private String email;
	
	// Apply date formatting for birthDay field
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthDay;
	
    // Constructor with parameters
	public UserDTO(String name, String email, Date birthDay) {
		super();
		this.name = name;
		this.email = email;
		this.birthDay = birthDay;
	}
	
	// Static method to convert User entity to UserDTO
	public static UserDTO convertToDTO(User obj) {
	    return new UserDTO(obj.getName(), obj.getEmail(), obj.getBirthDay());
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	// To String
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", birthDay=" + birthDay + "]";
	}
}
