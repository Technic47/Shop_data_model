package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends AbstractRepository<Product> {

    List<Product> findAllByOwner(UUID ownerId);
}
