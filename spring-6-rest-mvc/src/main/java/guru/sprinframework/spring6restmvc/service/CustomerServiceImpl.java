package guru.sprinframework.spring6restmvc.service;

import guru.sprinframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;
    public CustomerServiceImpl(){
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Matej Gace")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Lana Pavic")
                .version(2)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
    }
    @Override
    public List<Customer> customerList(){
        return new ArrayList<>(customerMap.values());
    }
    @Override
    public Customer getCustomerById(UUID id) {

        log.debug("Get customer Id - in service. ID: " + id.toString());
        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .customerName(customer.getCustomerName())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);
        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {

        Customer existingCustomer = customerMap.get(customerId);
                existingCustomer.setCustomerName(customer.getCustomerName());

    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {

        Customer existingCustomer = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getCustomerName())) {
            existingCustomer.setCustomerName(customer.getCustomerName());
        }
    }


}
