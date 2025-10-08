package ru.kuznetsov.data_model.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.data_model.model.Product;

@Repository
public interface ProductRepository extends AbstractRepository<Product> {
}
