package ru.kuznetsov.datamodel.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.datamodel.model.Product;

@Repository
public interface ProductRepository extends AbstractRepository<Product> {
}
