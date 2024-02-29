package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // do not replace the database/datasource (use the real one) so that we can test the real database or use the configured one in application.properties
public class MysqlIntegrationTest {
    @Autowired
    BookRepository bookRepository;
    @Test
    public void testRepo() {
//        Long count = bookRepository.count();
//        assertThat(count).isGreaterThan(2);
    }
}
