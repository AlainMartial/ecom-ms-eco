package net.martial.billingservice.feign;

import net.martial.billingservice.circuitbreaker.ProductRestClientFallback;
import net.martial.billingservice.config.FeignConfig;
import net.martial.billingservice.model.Product;
import net.martial.billingservice.model.ProductPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", configuration = FeignConfig.class, fallback = ProductRestClientFallback.class)
public interface ProductRestClient {

    @GetMapping("/api/products/{id}")
    Product getProduct(@PathVariable String id);

    @GetMapping("/api/products")
    ProductPage getAllProducts(); // ← Remplace PagedModel<Product>
}
