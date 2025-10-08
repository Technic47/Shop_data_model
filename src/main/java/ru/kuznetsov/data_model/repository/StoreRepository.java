package ru.kuznetsov.data_model.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.data_model.model.Store;

import java.util.Optional;

@Repository
public interface StoreRepository extends AbstractRepository<Store> {

    Optional<Store> findByName(String name);
}
