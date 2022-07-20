package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repository.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("author1", "author1");
        Book book1 = new Book("book1", "book1");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("author2", "author2");
        Book book2 = new Book("book2", "book2");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("book count " + bookRepository.count());
        System.out.println("author count " + authorRepository.count());
    }

}
