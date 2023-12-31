package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsTrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootsTrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author authorExample1 = new Author("Author", "Example1");
        Book bookExample1 = new Book("Book Example1", "AFGH231");
        authorExample1.getBooks().add(bookExample1);
        bookExample1.getAuthors().add(authorExample1);

        authorRepository.save(authorExample1);
        bookRepository.save(bookExample1);

        Author authorExample2 = new Author("Author", "Example2");
        Book bookExample2 = new Book("Book Example2", "GHAF231");
        authorExample2.getBooks().add(bookExample2);
        bookExample2.getAuthors().add(authorExample2);

        authorRepository.save(authorExample2);
        bookRepository.save(bookExample2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
