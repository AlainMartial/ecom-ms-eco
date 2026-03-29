package net.martial.billingservice;

import net.martial.billingservice.entities.Bill;
import net.martial.billingservice.entities.ProductItem;
import net.martial.billingservice.feign.CustomerRestClient;
import net.martial.billingservice.feign.ProductRestClient;
import net.martial.billingservice.model.Customer;
import net.martial.billingservice.model.Product;
import net.martial.billingservice.repository.BillRepository;
import net.martial.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return arg -> {
            Collection<Customer> customers = customerRestClient
                    .getAllCustomers()
                    .getEmbedded()
                    .getCustomers();
            Collection<Product> products = productRestClient.getAllProducts().getProducts();

            customers.forEach(customer -> {
                Bill bill = Bill.builder().
                        billingDate(new Date()).
                        customerId(customer.getId()).
                        build();
                billRepository.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder().
                            bill(bill).
                            productId(product.getId()).
                            quantity(1+new Random().nextInt(10)).
                            unitPrice(product.getPrice()).
                            build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
