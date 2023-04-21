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

        Author matej = new Author();
        matej.setFirstName("Matej");
        matej.setLastName("Gace");

        Book mg = new Book();
        mg.setTitle("MG11");
        mg.setIsbn("123456");

        Author matejSaved = authorRepository.save(matej);
        Book mgSaved = bookRepository.save(mg);

        Author marija = new Author();
        marija.setFirstName("Marija");
        marija.setLastName("Mamic");

        Book mm = new Book();
        mm.setTitle("MM");
        mm.setIsbn("987654");

        Author marijaSaved = authorRepository.save(marija);
        Book mmSaved = bookRepository.save(mm);

        matejSaved.getBooks().add(mg);
        marijaSaved.getBooks().add(mm);

        System.out.println("in Bootstrap");
        System.out.println("Author count " +  +authorRepository.count());
        System.out.println("Book count " + bookRepository.count());
    }
}
