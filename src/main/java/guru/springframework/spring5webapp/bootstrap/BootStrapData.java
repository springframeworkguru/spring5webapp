package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Author;
import guru.springframework.spring5webapp.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Author sam = new Author("Sam","Rossilli");
        Book goodBook = new Book("The End of the World", "dasdk13241");
        sam.getBooks().add(goodBook);
        goodBook.getAuthors().add(sam);

        authorRepository.save(sam);
        bookRepository.save(goodBook);

        Author bob = new Author("Bob","Ross");
        Book badBook = new Book("Happy Accidents", "adfsdfa342");
        bob.getBooks().add(badBook);
        badBook.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(badBook);

        System.out.println("In Running bootstrap");
        System.out.println("Num of Books" + bookRepository.count());

    }

}
