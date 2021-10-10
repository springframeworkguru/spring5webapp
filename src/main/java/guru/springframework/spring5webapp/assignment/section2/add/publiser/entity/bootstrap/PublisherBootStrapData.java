package guru.springframework.spring5webapp.assignment.section2.add.publiser.entity.bootstrap;

import guru.springframework.spring5webapp.assignment.section2.add.publiser.entity.domain.Publisher;
import guru.springframework.spring5webapp.assignment.section2.add.publiser.entity.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PublisherBootStrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public PublisherBootStrapData(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("name", "Address line 1, city, state, zip");

        publisherRepository.save(publisher);

        System.out.println("Number of publisher: " + publisherRepository.count());
    }
}
