package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Store;

import java.util.Optional;

@Repository
public interface StoreRepository extends AbstractRepository<Store> {

    Optional<Store> findByName(String name);
}
