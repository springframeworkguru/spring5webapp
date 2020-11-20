package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author john = new Author("john", "steinbeck");
        Book tgw = new Book("The Grapes of Wrath", "1111111111111");
        john.getBooks().add(tgw);
        tgw.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(tgw);

        Author frank = new Author("frank", "herbert");
        Book dune = new Book("Dune", "2222222222222");
        frank.getBooks().add(dune);
        dune.getAuthors().add(frank);

        authorRepository.save(frank);
        bookRepository.save(dune);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
