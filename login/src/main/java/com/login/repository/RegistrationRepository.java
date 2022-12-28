package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user where username=? and password=?", nativeQuery = true)
	public User findByUsernameAndPassword(String username, String password);


}
