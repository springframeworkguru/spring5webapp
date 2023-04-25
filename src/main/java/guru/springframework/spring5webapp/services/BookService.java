package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
