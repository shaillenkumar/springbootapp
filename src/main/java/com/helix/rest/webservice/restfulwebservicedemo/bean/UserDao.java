package com.helix.rest.webservice.restfulwebservicedemo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> users = new ArrayList<>();
	private static int usercount = 3;
	
	// Define static block to initialize List for the DEMO purpose
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Abdul", new Date()));
		users.add(new User(3, "Ankur", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId()==null) {
			user.setId(++usercount);
		}
		if(user.getDate()==null) {
			user.setDate(new Date());
		}
		users.add(user);
		return user;
	}
	
	
	public User findOne(int id) {
		System.out.print("findOne - id: "+id);
		for (User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}			
		}
		return null;		
	}
	
}
