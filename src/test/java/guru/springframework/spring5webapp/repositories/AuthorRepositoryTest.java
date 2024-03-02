package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@ActiveProfiles("local")
@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // do not replace the database/datasource (use the real one) so that we can test the real database or use the configured one in application.properties

public class AuthorRepositoryTest extends TestCase {

    @Autowired
    BookRepository bookRepository;
    @Test
    public void test() {
        AtomicInteger count = new AtomicInteger();
        bookRepository.findAllByTitleNotNull().forEach(book -> {
            System.out.println(book);
            count.getAndIncrement();
        });
        assertEquals(5, count.get());
    }

    @Test
    public void name() {
        String s = bookRepository.findBytitleWithQuery("Clean Code");
        assertEquals("Clean Code", s);
    }

    @Test
    public void id() {
        Book s = bookRepository.getById(5L);
        assertEquals("Clean Code", s.getTitle());
    }

//    @Test
//    public void endDate() {
//        LocalDate localDate = LocalDate.of(2024, 2, 20);
//        Book s = bookRepository.findByDateRangeEndDate(localDate);
//        System.out.println("aaaaaa" + s.getId());
//        assertNotNull(s);
//    }
}