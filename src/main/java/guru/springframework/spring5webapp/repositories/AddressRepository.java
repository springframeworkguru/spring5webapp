package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
