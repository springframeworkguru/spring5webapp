package guru.springframework.spring5webapp.bootStrapData;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookAuthorData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author auth1 = new Author("Evan","Presley");
        Book book1 = new Book("Domains","IS1224");
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);

        authorRepository.save(auth1);
        bookRepository.save(book1);


        Author auth2 = new Author("Melvis","Presley");
        Book book2 = new Book("Art","IS1225");
        auth1.getBooks().add(book2);
        book1.getAuthors().add(auth2);

        authorRepository.save(auth2);
        bookRepository.save(book2);

        System.out.println("started in bootstarp");
        System.out.println("books count"+ bookRepository.count());

    }
}
