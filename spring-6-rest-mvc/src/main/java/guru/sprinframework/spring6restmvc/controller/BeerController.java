package guru.sprinframework.spring6restmvc.controller;

import guru.sprinframework.spring6restmvc.model.Beer;
import guru.sprinframework.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

        private final BeerService beerService;

        @RequestMapping(method = RequestMethod.GET)
        public List<Beer> listBeers(){
                return beerService.listBeer();

        }

        @RequestMapping(value="/{beerId}", method = RequestMethod.GET)
        public Beer getBeerById(@PathVariable("beerId") UUID beerId){

                log.debug("Get Beer by Id - in controller");

                return  beerService.getBeerById(beerId);
        }

}
