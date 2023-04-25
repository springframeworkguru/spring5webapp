package guru.sprinframework.spring6restmvc.controller;

import guru.sprinframework.spring6restmvc.model.Beer;
import guru.sprinframework.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {

        private final BeerService beerService;

        @RequestMapping("/api/v1/beer")
        public List<Beer> listBeera(){
                return beerService.listBeer();
        }

        public Beer getBeerById(UUID id){

                log.debug("Get Beer by Id - in controller");

                return  beerService.getBeerById(id);
        }

}
