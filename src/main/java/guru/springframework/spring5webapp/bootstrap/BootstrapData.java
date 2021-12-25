package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author isan = new Author("Isan", "Sahoo");
        Book test = new Book("TestBook", "123abc");
        isan.getBooks().add(test);
        test.getAuthors().add(isan);

        authorRepository.save(isan);
        bookRepository.save(test);

        System.out.println("Started bootstrap...");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
