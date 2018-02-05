package guru.org.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import guru.org.springframework.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
