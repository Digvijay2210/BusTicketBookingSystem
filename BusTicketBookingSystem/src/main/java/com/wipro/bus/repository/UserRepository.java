package com.wipro.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);    
	Optional<User> deleteByName(String name);

}
