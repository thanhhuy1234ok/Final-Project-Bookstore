package com.bookstore.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.admin.repository.UserRepository;
import com.bookstore.model.entities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) {
		return userRepository.getById(id);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
}
