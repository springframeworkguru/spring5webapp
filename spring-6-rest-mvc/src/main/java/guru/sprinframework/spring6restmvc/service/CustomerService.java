package guru.sprinframework.spring6restmvc.service;

import guru.sprinframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> customerList();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID customerId);


    void patchCustomerById(UUID customerId, Customer customer);
}
