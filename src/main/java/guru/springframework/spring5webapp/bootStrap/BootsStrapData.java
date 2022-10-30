package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class BootsStrapData implements CommandLineRunner {


    private  final  AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootsStrapData ( AuthorRepository authorRepository , BookRepository bookRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository   = bookRepository;
    }

    @Override
    public void run ( String... args ) throws Exception {


        Author nanna = new Author ( "nanna " , "dash" );
        Book nannaBook = new Book ("SpringBoot ", "12347878");

        nanna.getBooks ().add ( nannaBook );
        nannaBook.getAuthors ().add ( nanna );
        authorRepository.save ( nanna );
        bookRepository.save ( nannaBook );

        Author rod  = new Author ("rod", "johnson");
        Book ejb = new Book ( "J2EE", "67868234" );
        rod.getBooks ().add ( ejb );
        ejb.getAuthors ().add ( rod );
        authorRepository.save ( rod );
        bookRepository.save ( ejb );
        System.out.println ("Starting bootStrap  ...... ");
        System.out.println ( "number Of books  :  :: " +bookRepository.count ());
//        Iterable < Author > allAuthor = authorRepository.findAll ();
//        Iterator < Author > iterator  = allAuthor.iterator ();
//        for (  )
    }
}
