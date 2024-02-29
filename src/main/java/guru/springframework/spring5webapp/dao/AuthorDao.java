package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorDao {

    Author getById(Long id);

    Author findAuthorByName(String firstName, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);
    List<Author> getAllAuthors(int page, int offset);
    List<Author> getAllAuthors(Pageable pageable);
    List<Author> getAuthorByFirstName(String firstName, Pageable pageable);

}
