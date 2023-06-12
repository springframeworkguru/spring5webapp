package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


// I could also have used the annotations
public interface BookRepository extends JpaRepository<Book, Long> {
}
