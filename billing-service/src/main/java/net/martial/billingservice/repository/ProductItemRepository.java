package net.martial.billingservice.repository;

import net.martial.billingservice.entities.ProductItem;
import net.martial.billingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> product(Product product);
}
