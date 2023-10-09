package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// Fields for userDTO data
	
	// The @Id annotation marks this field as the primary key in the database table.
	@Id
	// The @Table annotation specifies the name of the database table corresponding to this entity.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	// Apply date formatting for birthDay field
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthDay;
	
    // Default constructor
	public User() {
	}
	
    // Constructor with parameters
	public User(Long id, String name, String email, String password, Date birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDay = birthDay;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthDay="
				+ birthDay + "]";
	}

		
}

