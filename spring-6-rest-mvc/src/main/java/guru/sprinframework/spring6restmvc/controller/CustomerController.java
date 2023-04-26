package guru.sprinframework.spring6restmvc.controller;

import guru.sprinframework.spring6restmvc.model.Beer;
import guru.sprinframework.spring6restmvc.model.Customer;
import guru.sprinframework.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PatchMapping("{customerId}")
    public ResponseEntity updateCustomerPatchById (@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){

        customerService.patchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId){

        customerService.deleteById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateById (@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){

        customerService.updateCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){

        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> customerList(){
        return customerService.customerList();
    }
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById (@PathVariable("customerId")UUID customerId){
        log.debug("Get Customer by Id - in controller 042 ");

        return customerService.getCustomerById(customerId);

    }

}
