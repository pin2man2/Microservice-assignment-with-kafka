package com.amdocs.media.assigment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.media.assigment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 Optional<User> findByUserName(String userName);

}
