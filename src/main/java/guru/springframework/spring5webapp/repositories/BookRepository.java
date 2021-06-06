package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.spring5webapp.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    
}
