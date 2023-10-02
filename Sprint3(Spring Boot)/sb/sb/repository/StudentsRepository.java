package com.library.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.sb.entity.Students;


public interface StudentsRepository extends JpaRepository<Students, Integer>{

	@Query("Select sf from Students sf where sf.sfname=?1")
	List<Students> findStudentsByName(String sfname);
	}
