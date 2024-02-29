package guru.springframework.spring5webapp.bootstrab;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        bookRepository.deleteAll();
//        Book book1 = Book.builder().title("spide man").isbn("asd").publisher("mikhail").build();
//        Book savedBook1 = bookRepository.save(book1);
//        Book book2 = Book.builder().title("spide man").isbn("asd").publisher("mikhail").build();
//        Book savedBook2 = bookRepository.save(book2);
//
//        bookRepository.findAll().forEach(book -> {
//                    System.out.println("book id = " + book.getId());
//                    System.out.println("book title = " + book.getTitle());
//                }
//        );
    }
}
