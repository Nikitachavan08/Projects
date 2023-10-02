package com.library.sb.service;

import java.util.List;

import com.library.sb.entity.Students;

public interface StudentService {
	
	//method for saving Students details in db table
	Students addStudents(Students student);
	
	//method to fetch Students detail based on sid from db table
	Students getStudentsDetails(int sid);
	
	//method to modify Students detail based on sid from db table
	Students updateStudentsDetail(Students student, int sid);
		
	//method to remove Students detail based on sid from db table
	void deleteStudentsDetail(int sid);
	
	//method to fetch teacher details based on firstname
	List<Students> getStudentsByName(String sfname);
	
}
