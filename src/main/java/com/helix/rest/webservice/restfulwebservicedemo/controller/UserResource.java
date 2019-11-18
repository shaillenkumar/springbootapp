package com.helix.rest.webservice.restfulwebservicedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helix.rest.webservice.restfulwebservicedemo.bean.UserDao;
import com.helix.rest.webservice.restfulwebservicedemo.exception.UserNotFoundException;
import com.helix.rest.webservice.restfulwebservicedemo.bean.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class UserResource {
	
	@Autowired
	private UserDao userDao;
	
	// Get AllUsers - http://localhost:8080/home/users
	@GetMapping("/users")
	public List<User> retrieveAlUsers(){
		return userDao.findAll();
	}
	
	//Get single user URL -  http://localhost:8080/home/users/1
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User usr = userDao.findOne(id);
		if(usr==null) throw new UserNotFoundException("id ->"+id);
		return usr ;
	}
	
	// Post Mapping for createUser. Add annotation @Valid for validation.
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDao.save(user);
		// to respond back with the Created Request URL 
		// to indicate successful creation.
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Delete single user URL -  http://localhost:8080/home/users/1
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id){
		User usr = userDao.deleteById(id);
		if(usr==null) throw new UserNotFoundException("id ->"+id);
		return usr ;
	}
	

}
