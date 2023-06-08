package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        //create some basic objects
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //this is used to save the objects into a repository
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Publisher Repository Test
        Publisher oriely = new Publisher("O'Reilly", "Street Address", "City", "State", "1111");

        Author dawn = new Author("Dawn", "Griffiths");
        Book androidDev = new Book("Android Development", "56789");
        dawn.getBooks().add(androidDev);
        androidDev.getAuthors().add(dawn);
        androidDev.setPublisher(oriely);

        authorRepository.save(dawn);

        //you have to save an instance originally to create a reference to it
        publisherRepository.save(oriely);
        bookRepository.save(androidDev);

        androidDev.setPublisher(oriely);
        oriely.getBooks().add(androidDev);

        authorRepository.save(dawn);

        publisherRepository.save(oriely);
        bookRepository.save(androidDev);




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + oriely.getBooks().size());



        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
