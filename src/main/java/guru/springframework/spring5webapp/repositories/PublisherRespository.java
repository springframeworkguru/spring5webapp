package guru.springframework.spring5webapp.repositories;


import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespository extends CrudRepository<Publisher,Long> {
}
