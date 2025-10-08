package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Product;

@Repository
public interface ProductRepository extends AbstractRepository<Product> {
}
