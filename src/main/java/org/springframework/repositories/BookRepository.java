package guru.org.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import guru.org.springframework.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
