package net.martial.billingservice.circuitbreaker;

import net.martial.billingservice.feign.ProductRestClient;
import net.martial.billingservice.model.Product;
import net.martial.billingservice.model.ProductPage;
import org.springframework.stereotype.Component;

@Component
public class ProductRestClientFallback implements ProductRestClient {

    @Override
    public Product getProduct(String id) {
        Product fallback = new Product();
        fallback.setId(id);
        fallback.setName("Product unavailable");
        fallback.setPrice(0);
        fallback.setQuantity(0);
        return fallback;
    }

    @Override
    public ProductPage getAllProducts() {
        return new ProductPage(); // liste vide
    }
}
