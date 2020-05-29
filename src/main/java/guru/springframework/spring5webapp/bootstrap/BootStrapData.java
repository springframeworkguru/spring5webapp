package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
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

        //create authors and books
        Author ericEvans = new Author("Eric", "Evans");
        Book domainDrivenDesign = new Book("Domain Driven Design","12341234");
        Author rodJohnson = new Author("Rod", "Johnson");
        Book j2eeDevelopment = new Book("J2EE Development without EJB","43214321");

        //add books to authors and vice-versa
        ericEvans.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(ericEvans);
        rodJohnson.getBooks().add(j2eeDevelopment);
        j2eeDevelopment.getAuthors().add(rodJohnson);

        //add authors and books to repositories (H2)
        authorRepository.save(ericEvans);
        authorRepository.save(rodJohnson);
        bookRepository.save(domainDrivenDesign);
        bookRepository.save(j2eeDevelopment);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
    }
}
