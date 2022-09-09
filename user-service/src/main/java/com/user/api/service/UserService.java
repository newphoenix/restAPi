package com.user.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.api.entity.User;
import com.user.api.exception.NotFoundException;
import com.user.api.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Integer id) {		
		return userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found with id: "+id));
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found with id: "+id));
		userRepository.delete(user);
		
	}

}
