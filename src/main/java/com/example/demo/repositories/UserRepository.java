package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

//The JpaRepository interface is used to interact with the User entity in the database.
public interface UserRepository extends JpaRepository<User, Long>{

}
