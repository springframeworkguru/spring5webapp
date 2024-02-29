package guru.springframework.spring5webapp.repositories;


import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
    Slice<Author> findAuthorByFirstName(String firstName, Pageable pageable);
}
