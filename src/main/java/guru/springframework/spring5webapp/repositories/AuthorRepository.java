////////////////////////////////////////////////////////////////////////////////
//
// Create by pbecker on 25.03.22.
//
// Copyright (c) 2022 Peter Becker. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
