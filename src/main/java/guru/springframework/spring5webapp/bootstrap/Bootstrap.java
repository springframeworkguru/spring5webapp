package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Model.Author;
import guru.springframework.spring5webapp.Model.Book;
import guru.springframework.spring5webapp.Repositories.AuthorRepository;
import guru.springframework.spring5webapp.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author("Gorge","cavin");
        Author a2 = new Author("Brayn","Adams");
        Book b1 = new Book("GOT","112");
        Book b2 = new Book("GOT2","1312");
        a1.getBooks().add(b1);
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        b1.getAuthors().add(a1);
        authorRepository.save(a1);
        authorRepository.save(a2);
        bookRepository.save(b1);
        bookRepository.save(b2);
        System.out.println("No of Books: " + bookRepository.count());
        System.out.println("No Of Authors: " + authorRepository.count());
    }
}
