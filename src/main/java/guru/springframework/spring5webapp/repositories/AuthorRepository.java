package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 12/23/19.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
