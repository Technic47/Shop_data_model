package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Store;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoreRepository extends AbstractRepository<Store> {

    Optional<Store> findByName(String name);

    List<Store> findAllByAddressId(Long addressId);

    List<Store> findAllByOwner(UUID owner);
}
