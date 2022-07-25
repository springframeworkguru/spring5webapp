package guru.springframework.spring5webapp.Repositories;

import guru.springframework.spring5webapp.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
