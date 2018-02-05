package guru.org.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.org.springframework.model.Author;
import guru.org.springframework.model.Book;
import guru.org.springframework.repositories.AuthorRepository;
import guru.org.springframework.repositories.BookRepository;

/**
 * 
 * @author jacopo.sciacca
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	/**
	 * 
	 */
	private AuthorRepository authorRepository;
	
	/**
	 * 
	 */
	private BookRepository bookRepository;
	
	public DevBootstrap(
			AuthorRepository authorRepository,
			BookRepository bookRepository) 
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	/**
	 * 
	 */
	private void initData() {
		Author ericE = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234567", "Harper Collins");
		ericE.getBooks().add(ddd);
		ddd.getAuthors().add(ericE);
		
		Author rodJ = new Author("Rod", "Johnson");
		Book noEjb = new Book("J2EE Development without ejb", "1325674", "Worx");
		
		authorRepository.save(ericE);
		authorRepository.save(rodJ);
		bookRepository.save(ddd);
		bookRepository.save(noEjb);
		
	}
}
