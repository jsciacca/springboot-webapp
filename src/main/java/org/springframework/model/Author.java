package guru.org.springframework.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author jacopo.sciacca
 *
 */
@Entity
public class Author {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * name of the author
	 */
	private String name;
	
	/**
	 * last name of the author
	 */
	private String lastName;
	
	/**
	 * set of books published by a specific author
	 */
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		
	}
	
	public Author(
			String name, String lastName)
	{
		this.name = name;
		this.lastName = lastName;
		this.books = new HashSet<>();
	}
	
	public Author(
			String name, String lastName,
			Set<Book> books) 
	{
		this.name = name;
		this.lastName = lastName;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
