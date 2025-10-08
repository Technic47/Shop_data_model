package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.ProductCategory;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends AbstractRepository<ProductCategory> {

    Optional<ProductCategory> findByName(String name);
}
