package ru.kuznetsov.datamodel.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.datamodel.model.ProductCategory;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends AbstractRepository<ProductCategory> {

    Optional<ProductCategory> findByName(String name);
}
