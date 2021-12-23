package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Author;
import guru.springframework.spring5webapp.Book;
import guru.springframework.spring5webapp.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisterRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisterRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author sam = new Author("Sam","Rossilli");
        Book goodBook = new Book("The End of the World", "dasdk13241");

        Publisher pub = new Publisher("Fmea","dfakld","Ddafsd","dfadsfSdfA",Long.valueOf(3803));
        publisterRepository.save(pub);

        sam.getBooks().add(goodBook);
        goodBook.getAuthors().add(sam);
        pub.getBooks().add(goodBook);




        authorRepository.save(sam);
        bookRepository.save(goodBook);
        publisterRepository.save(pub);

        System.out.println("N PUB: " + publisterRepository.count());


    }

}
