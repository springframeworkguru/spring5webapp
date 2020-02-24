package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public BootStrapData(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("Merlin", "Chicago", "Ohaio", "00-000");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
