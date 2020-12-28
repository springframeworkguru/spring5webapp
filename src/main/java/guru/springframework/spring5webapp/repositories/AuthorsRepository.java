package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
