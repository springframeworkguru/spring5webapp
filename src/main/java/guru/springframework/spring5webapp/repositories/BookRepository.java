package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.pojo.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
