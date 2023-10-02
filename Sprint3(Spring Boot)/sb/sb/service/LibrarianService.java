package com.library.sb.service;

import com.library.sb.entity.Librarian;

public interface LibrarianService {
	
	//method for saving Students details in db table
	Librarian addLibrarian(Librarian librarian);
		
		//method to fetch Students detail based on lid from db table
	Librarian getLibrarianDetails(int lid);
		
		//method to modify Students detail based on lid from db table
	Librarian updateLibrarianDetail(Librarian librarian, int lid);
			
		//method to remove Students detail based on lid from db table
		void deleteLibrarianDetail(int lid);

	}
