package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ivan D.
 * Date: 11/2/2019
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
