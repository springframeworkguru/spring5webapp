package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domin.Author;
import guru.springframework.spring5webapp.domin.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData  implements CommandLineRunner {
    private  final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    public bootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // init the data in the construct

        //example 1
        Author wali=new Author("wali","hassan");
        Book home=new Book("home sweet home","121212");

        //example2
        Author ali=new Author("ali","omer");
        Book lorem=new Book("lorem apsum","14444");

        // add data to database h2

        wali.getBooks().add(home);
        home.getAuthors().add(wali);
        authorRepository.save(wali);
        bookRepository.save(home);

        ali.getBooks().add(lorem);
        lorem.getAuthors().add(ali);
        authorRepository.save(ali);
        bookRepository.save(lorem);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books is :"+ " "+ bookRepository.count());
        System.out.println("Number of Authors is :"+ " "+ authorRepository.count());

    }
}
