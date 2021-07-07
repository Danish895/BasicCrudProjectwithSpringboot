package com.example.demo.model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	
	
	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	
	
	public void saveMyUser (User user) {
		
		repo.save(user);
	}
	public Iterable<User> showAllUsers(){
		return repo.findAll();
	}
	
	public Iterable<User> deleteUserByUsername(String username){
		repo.deleteByUsername(username);
		return repo.findAll();
	}
	
	public List<User> findByUsername(String username) {
		List<User> list= repo.findByUsernameContainingIgnoreCase(username);
		return list;
	}

}
