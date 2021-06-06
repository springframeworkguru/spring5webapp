package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;    
    private final BookRepository bookRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driver Desing", "12121212");
        
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev without EJB", "99887766");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Authors:" + authorRepository.count());
        
        
    }

    
    
}
