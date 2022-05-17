package com.example.UserM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserM.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String em);

}