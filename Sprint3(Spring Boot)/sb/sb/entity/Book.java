package com.library.sb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Book entity with all parameter
@Entity
@Table(name="BookInfo")

@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	private int bid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Book Name cannot be blank")
	private String bname;
	
	@Column(length=20, nullable = false)
	@NotBlank(message ="Book author name cannot be blank")
	private String bauthor;
	
	@Column(length=11, nullable = false)
	@NotNull(message = "Book Price cannot be null")
	private int bprice;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = " description cannot be blank")
	private String bdescription;
	
	@OneToOne(mappedBy = "book",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Students student;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="librarianID", referencedColumnName = "lid")
	@JsonBackReference
	private Librarian librarian;
	
}