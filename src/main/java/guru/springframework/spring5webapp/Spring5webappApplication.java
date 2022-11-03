package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}

