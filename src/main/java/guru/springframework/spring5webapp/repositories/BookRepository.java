package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, Long> {
    Stream<Book> findAllByTitleNotNull();

    @Query("select b.title from Book b where b.title= ?1")
    String findBytitleWithQuery(String title);

    Book getById(Long id);

    @Query("select b from Book b where b.dateRange.endDate = :endDate")
    Book findByDateRangeEndDate(@Param("endDate") LocalDate endDate);

}
