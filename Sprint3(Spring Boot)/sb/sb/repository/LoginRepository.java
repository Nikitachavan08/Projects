package com.library.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.sb.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	public Login findByUserNameAndPassword(String userName, String Password);
}