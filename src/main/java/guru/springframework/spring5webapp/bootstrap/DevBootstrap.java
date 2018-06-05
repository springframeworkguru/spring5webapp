package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher ericBookPublisher=new Publisher("Pearson Education","California,USA");
        publisherRepository.save(ericBookPublisher);

        Author eric=new Author("Eric","Evans");
        Book ericBook=new Book("Domain Driven Design","1234",ericBookPublisher);
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBook);

        Publisher rodBookPublisher=new Publisher("Macgraw Hill","Seattle,USA");
        publisherRepository.save(rodBookPublisher);

        Book rodBook=new Book("J2E Development Without EJB","1234",rodBookPublisher);
        Author rod=new Author("Rod","Johnson");
        rod.getBooks().add(rodBook);
        rodBook.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(rodBook);
    }
}
