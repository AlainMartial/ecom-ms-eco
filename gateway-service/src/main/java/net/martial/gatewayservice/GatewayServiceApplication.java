package net.martial.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", predicates -> predicates.path("/customers").uri("lb://CUSTOMER-SERVICE"))
                .route("r2", predicates -> predicates.path("/products").uri("lb://INVENTORY-SERVICE"))
                .route("r3", predicates -> predicates.path("/bills").uri("lb://BILLING-SERVICE"))
                .build();
    }

}
