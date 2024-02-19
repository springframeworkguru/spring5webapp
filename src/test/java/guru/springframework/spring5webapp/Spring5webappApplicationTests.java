package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5webappApplicationTests {
	@Autowired
	BookRepository bookRepository;

	@Test
	public void testRepo() {
		Long count = bookRepository.count();
		System.out.println(count);
		assertThat(count).isGreaterThan(2);

	}


}
