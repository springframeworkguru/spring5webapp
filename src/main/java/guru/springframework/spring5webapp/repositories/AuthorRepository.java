package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/*Spring data facilita las operaciones en la base de datos sobre todo
Implements data repository pattern
CrudReposittory es la utilidad que nos proporciona spring data para implementar el patron Repository
*/
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
