package com.library.sb.controller;

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

import com.library.sb.entity.Librarian;
import com.library.sb.service.LibrarianService;

import jakarta.validation.Valid;

@RestController
public class LibrarianController {
	
	@Autowired
	LibrarianService ls;
	
	@PostMapping("/addLibrarian")
	public ResponseEntity<Librarian> saveLibrarian(@Valid @RequestBody Librarian librarian){
		return new ResponseEntity<Librarian>(ls.addLibrarian(librarian),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/getLibrarian/{lid}")
	public ResponseEntity<Librarian> getLibrarian(@PathVariable("lid") int lid){
		return new ResponseEntity<Librarian>(ls.getLibrarianDetails(lid),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeLibrarian/{lid}")
	public ResponseEntity<String> deleteLibrarian(@PathVariable("lid") int lid){
		ls.deleteLibrarianDetail(lid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	
	@PutMapping("/editLibrarian/{lid}")
	public ResponseEntity<Librarian> editlibrarian(@Valid @PathVariable("lid") int lid, @RequestBody Librarian librarian){
		return new ResponseEntity<Librarian>(ls.updateLibrarianDetail(librarian, lid), HttpStatus.OK);
	}
}

