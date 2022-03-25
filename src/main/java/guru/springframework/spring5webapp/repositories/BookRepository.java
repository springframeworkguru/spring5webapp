////////////////////////////////////////////////////////////////////////////////
//
// Create by pbecker on 25.03.22.
//
// Copyright (c) 2022 Peter Becker. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
