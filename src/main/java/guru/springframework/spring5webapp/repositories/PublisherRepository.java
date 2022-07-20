package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan D.
 * Date: 11/2/2019
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
}
