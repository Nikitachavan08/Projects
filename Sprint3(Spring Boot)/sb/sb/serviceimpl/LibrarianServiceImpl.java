package com.library.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.sb.entity.Librarian;
import com.library.sb.exception.LibrarianIdNotFoundException;
import com.library.sb.repository.LibrarianRepository;
import com.library.sb.service.LibrarianService;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	LibrarianRepository lrepo;
	
	@Override
	public Librarian addLibrarian(Librarian librarian) {
		
		return lrepo.save(librarian);
	}

	@Override
	public Librarian getLibrarianDetails(int lid) {
		
		return lrepo.findById(lid).orElseThrow(()-> new LibrarianIdNotFoundException("Librarian id is incorrect"));
	}

	@Override
	public Librarian updateLibrarianDetail(Librarian librarian, int lid) {
		Librarian updatedlibrarian = lrepo.findById(lid).orElseThrow(()-> new LibrarianIdNotFoundException("Librarian id is incorrect"));

		//set new values
		updatedlibrarian.setLname(librarian.getLname());
		
		updatedlibrarian.setLemail(librarian.getLemail());
		
		updatedlibrarian.setLphone(librarian.getLphone());
		
		lrepo.save(updatedlibrarian);
		return updatedlibrarian;
		
	}

	@Override
	public void deleteLibrarianDetail(int lid) {
		
		lrepo.findById(lid).orElseThrow(()-> new LibrarianIdNotFoundException("Librarian id is incorrect"));
		lrepo.deleteById(lid);
		
	}

}
