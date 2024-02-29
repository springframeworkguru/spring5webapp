package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.domain.Book;

public interface BookDao {
    Book getById(Long id);


}
