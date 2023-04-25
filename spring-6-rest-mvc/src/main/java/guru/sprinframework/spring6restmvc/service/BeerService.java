package guru.sprinframework.spring6restmvc.service;

import guru.sprinframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeer();

    Beer getBeerById(UUID id);
}
