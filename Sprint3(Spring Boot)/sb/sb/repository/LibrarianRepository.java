package com.library.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.sb.entity.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}
