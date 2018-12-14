package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jt on 5/16/17.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
