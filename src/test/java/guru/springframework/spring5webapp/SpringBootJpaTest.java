package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SpringBootJpaTest {
    @Autowired
    BookRepository bookRepository;

    @Commit
    @Test
    public void testJpa() {
//        long countBefore = bookRepository.count();
//        bookRepository.save(Book.builder().title("new Book").isbn("isban").publisher("publishcer").build());
//        long countAfter = bookRepository.count();
//        assertThat(countBefore).isLessThan(countAfter);
    }
}
