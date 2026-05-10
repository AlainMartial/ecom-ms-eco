package net.martial.billingservice.circuitbreaker;

import net.martial.billingservice.feign.CustomerRestClient;
import net.martial.billingservice.model.Customer;
import net.martial.billingservice.model.CustomerPage;
import org.springframework.stereotype.Component;

@Component
public class CustomerRestClientFallback implements CustomerRestClient {

    @Override
    public Customer getCustomer(Long id) {
        Customer fallback = new Customer();
        fallback.setId(id);
        fallback.setName("Customer unavailable");
        fallback.setEmail("N/A");
        return fallback;
    }

    @Override
    public CustomerPage getAllCustomers() {
        return new CustomerPage(); // liste vide
    }
}
