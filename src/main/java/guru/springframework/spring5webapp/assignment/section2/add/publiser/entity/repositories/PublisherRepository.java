package guru.springframework.spring5webapp.assignment.section2.add.publiser.entity.repositories;

import guru.springframework.spring5webapp.assignment.section2.add.publiser.entity.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
