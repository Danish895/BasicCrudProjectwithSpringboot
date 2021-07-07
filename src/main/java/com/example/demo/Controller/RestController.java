package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.User;
import com.example.demo.model.Service.UserService;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService service;

	@PostMapping("/save-user")
	@Transactional
	public String registerUser(@RequestBody User user) {
		service.saveMyUser(user);
		return "Hello, " + user.getFirstname() + ", you are successfully registered";
	}

	@GetMapping("/all-user")
	public Iterable<User> showUsers() {
		return service.showAllUsers();
	}

	@GetMapping("/delete/{username}")
	@Transactional
	public Iterable<User> deleteUser(@PathVariable String username) {
		return service.deleteUserByUsername(username);
	}

	@GetMapping("/search/{username}")
	public Iterable<User> searchUser(@PathVariable String username) {
		return service.findByUsername(username);
	}
}