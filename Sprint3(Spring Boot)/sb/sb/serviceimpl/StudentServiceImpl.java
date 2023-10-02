package com.library.sb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.sb.entity.Students;
import com.library.sb.exception.StudentIdNotFoundException;
import com.library.sb.repository.StudentsRepository;
import com.library.sb.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentsRepository srepo;
	
	@Override
	public Students addStudents(Students student) {
		
		return srepo.save(student);
	}

	@Override
	public Students getStudentsDetails(int sid) {
		
		return srepo.findById(sid).orElseThrow(()-> new StudentIdNotFoundException("Student id is incorrect"));
	}

	@Override
	public Students updateStudentsDetail(Students student, int sid) {
		Students updatedstudent = srepo.findById(sid).orElseThrow(()-> new StudentIdNotFoundException("Student id is incorrect"));

		//set new values
		updatedstudent.setSeduc(student.getSeduc());
		
		srepo.save(updatedstudent);
		return updatedstudent;
	}
	@Override
	public void deleteStudentsDetail(int sid) {
		srepo.findById(sid).orElseThrow(()-> new StudentIdNotFoundException("Student id is incorrect"));
		srepo.deleteById(sid);
		
	}

	@Override
	public List<Students> getStudentsByName(String sfname) {
		// TODO Auto-generated method stub
		return srepo.findStudentsByName(sfname);
	
	}
	
}
