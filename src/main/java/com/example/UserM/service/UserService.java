package com.example.UserM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserM.entity.User;
import com.example.UserM.repository.UserRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public void addUser(User u) {

		userRepo.save(u);
	}

	public List<User> getAllUser() {
		return userRepo.findAll();

	}

	public User getUserByID(int id) {
		java.util.Optional<User> e = userRepo.findById(id);
		if (e.isPresent()) {

			return e.get();
		}
		return null;
	}

	public void deleteById(int id) {

		userRepo.deleteById(id);

	}

	public void deleteAll() {

		userRepo.deleteAll();
		;

	}

}
