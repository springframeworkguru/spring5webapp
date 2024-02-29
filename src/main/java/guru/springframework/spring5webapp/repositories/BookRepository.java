package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, Long> {
    Stream<Book> findAllByTitleNotNull();
    @Query("select b.title from Book b where b.title= ?1")
    String findBytitleWithQuery(String title);
    Book getById(Long id);
}
