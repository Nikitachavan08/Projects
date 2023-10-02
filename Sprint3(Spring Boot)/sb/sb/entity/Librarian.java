package com.library.sb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="LibrarianInfo")
@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
	
	@Id
	private int Lid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Librarian name cannot be blank")
	private String lname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Librarian phone cannot be null")
	private long lphone;
	
	@Column(length=20, nullable = false, unique = true)
	@NotBlank(message = "Librarian Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String lemail;
	
	@OneToMany(mappedBy = "librarian", 
		     fetch = FetchType.EAGER, cascade = CascadeType.ALL)
			@JsonManagedReference
			private List<Book> bookDetails;
	
}
