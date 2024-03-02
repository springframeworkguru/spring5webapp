package guru.springframework.spring5webapp.bootstrab;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder().id(12830L).title("spide massn").isbn("asd").publisher("mikhail").result(Result.PASSED).build();
        Book savedBook1 = bookRepository.save(book1);
    }
}
