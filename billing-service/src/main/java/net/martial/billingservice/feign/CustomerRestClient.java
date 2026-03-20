package net.martial.billingservice.feign;

import net.martial.billingservice.config.FeignConfig;
import net.martial.billingservice.model.Customer;
import net.martial.billingservice.model.CustomerPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", configuration = FeignConfig.class)
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    Customer getCustomer(@PathVariable Long id);

    @GetMapping("/api/customers")
    CustomerPage getAllCustomers();
}
