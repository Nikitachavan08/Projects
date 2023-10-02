package com.library.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.sb.entity.Students;
import com.library.sb.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentsController {

	@Autowired
	StudentService ss;
	
	@PostMapping("/addStudents")
	public ResponseEntity<Students> saveStudents(@Valid @RequestBody Students studenss){
		return new ResponseEntity<Students>(ss.addStudents(studenss),
				HttpStatus.CREATED);
	}
	
	//@GetMapping("/getstudents/{sid}")
	public ResponseEntity<Students> gesstudents(@PathVariable("sid") int sid){
		return new ResponseEntity<Students>(ss.getStudentsDetails(sid),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeStudents/{sid}")
	public ResponseEntity<String> deleteStudents(@PathVariable("sid") int sid){
		ss.deleteStudentsDetail(sid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	
	@PutMapping("/editstudents/{sid}")
	public ResponseEntity<Students> editstudents(@Valid @PathVariable("sid") int sid, @RequestBody Students students){
		return new ResponseEntity<Students>(ss.updateStudentsDetail(students, sid), HttpStatus.OK);
		
	}
		@GetMapping("/getsfname/{sfname}")
		public List<Students> getStudentsName(@PathVariable("sfname") String sfname){
			return ss.getStudentsByName(sfname);
		
	}
}










