package ru.kuznetsov.data_model.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.data_model.model.ProductCategory;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends AbstractRepository<ProductCategory> {

    Optional<ProductCategory> findByName(String name);
}
