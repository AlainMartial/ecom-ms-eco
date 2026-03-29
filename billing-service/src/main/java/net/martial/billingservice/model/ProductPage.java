package net.martial.billingservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductPage {

    @JsonProperty("_embedded")
    private Embedded embedded;

    @Data
    @NoArgsConstructor
    public static class Embedded {
        private List<Product> products;
    }

    public List<Product> getProducts() {
        return embedded != null ? embedded.getProducts() : List.of();
    }
}
