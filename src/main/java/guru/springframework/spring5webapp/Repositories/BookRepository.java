package guru.springframework.spring5webapp.Repositories;

import guru.springframework.spring5webapp.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
