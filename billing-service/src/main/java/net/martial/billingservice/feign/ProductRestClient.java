package net.martial.billingservice.feign;

import net.martial.billingservice.config.FeignConfig;
import net.martial.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", configuration = FeignConfig.class)
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    Product getcustomer(@PathVariable String id);

    @GetMapping("/api/products")
    PagedModel<Product> getAllProducts();
}
