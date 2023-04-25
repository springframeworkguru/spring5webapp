package guru.sprinframework.spring6restmvc.service;

import guru.sprinframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> customerList();

    Customer getCustomerById(UUID id);
}
