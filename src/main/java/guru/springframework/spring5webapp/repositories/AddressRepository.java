package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * @author igorg
 * @Date 17.04.2022
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
