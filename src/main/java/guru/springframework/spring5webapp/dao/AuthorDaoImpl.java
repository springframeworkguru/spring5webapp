package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AuthorDaoImpl implements AuthorDao {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Author> getAuthorByFirstName(String firstName, Pageable pageable) {
        return authorRepository.findAuthorByFirstName(firstName, pageable).getContent();
    }

    public List<Author> getAllAuthors(int page, int size) {
        return authorRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(RuntimeException::new);
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public Author updateAuthor(Author author) {
        Author foundAuthor = authorRepository.findById(author.getId()).orElse(null);
        if (foundAuthor == null) {
            return null;
        }
        foundAuthor.setFirstName(author.getFirstName());
        foundAuthor.setLastName(author.getLastName());

        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}







