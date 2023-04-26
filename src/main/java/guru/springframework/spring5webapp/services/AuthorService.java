package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
