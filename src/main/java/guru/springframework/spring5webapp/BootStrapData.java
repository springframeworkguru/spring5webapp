package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.entities.Publisher;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private PublisherRepository publisherRepository;

    public BootStrapData(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Begin BootStrapData");

        Publisher publisher = new Publisher();
        publisher.setAddressLine("Calle Augusto Figueroa");
        publisher.setCity("Madrid");
        publisher.setPostcode(28004);

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
