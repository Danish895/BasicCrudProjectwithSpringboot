package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	public Iterable<User> deleteByUsername(String username);

	public List<User> findByUsernameContainingIgnoreCase(String username);
	
}
 