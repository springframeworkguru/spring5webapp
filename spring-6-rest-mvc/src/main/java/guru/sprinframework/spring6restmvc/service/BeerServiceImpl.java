package guru.sprinframework.spring6restmvc.service;

import guru.sprinframework.spring6restmvc.model.Beer;
import guru.sprinframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j    // log in annotation
@Service
public class BeerServiceImpl implements BeerService {
    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 =  Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Heini")
                .beerStyle(BeerStyle.LAGER)
                .upc("12335")
                .price(new BigDecimal(12.19))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 =  Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Becks")
                .beerStyle(BeerStyle.LAGER)
                .upc("53226")
                .price(new BigDecimal(10.19))
                .quantityOnHand(142)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 =  Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Zuja")
                .beerStyle(BeerStyle.LAGER)
                .upc("56163")
                .price(new BigDecimal(9.19))
                .quantityOnHand(92)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer4 =  Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Karlo")
                .beerStyle(BeerStyle.LAGER)
                .upc("879321")
                .price(new BigDecimal(8.19))
                .quantityOnHand(182)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
        beerMap.put(beer4.getId(), beer4);

    }

    @Override
    public List<Beer> listBeer(){
        return new ArrayList<>(beerMap.values());
    }
    @Override
    public Beer getBeerById(UUID id) {

       log.debug("Get Beer Id - in  service. Id: " + id.toString());


        return beerMap.get(id);
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(savedBeer.getId(),savedBeer);

        return savedBeer;
    }

    @Override
    public void updateBeerById(UUID beerId, Beer beer) {

       Beer existingBeer = beerMap.get(beerId);
            existingBeer.setBeerName(beer.getBeerName());
            existingBeer.setBeerStyle(beer.getBeerStyle());
            existingBeer.setPrice(beer.getPrice());
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
            existingBeer.setUpc(beer.getUpc());


    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerById(UUID beerId, Beer beer) {

        Beer existingBeer = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getBeerName())) {
            existingBeer.setBeerName(beer.getBeerName());
        }
        if (beer.getBeerStyle() != null) {
            existingBeer.setBeerStyle(beer.getBeerStyle());
        }
        if (beer.getPrice() != null) {
            existingBeer.setPrice(beer.getPrice());
        }
        if (beer.getQuantityOnHand() != null) {
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }
        if (StringUtils.hasText(beer.getUpc())) {
            existingBeer.setUpc(beer.getUpc());
        }

    }
}
