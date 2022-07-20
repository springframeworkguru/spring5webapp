package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author igorg
 * @Date 11.04.2022
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
