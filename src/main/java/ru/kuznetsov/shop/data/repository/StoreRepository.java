package ru.kuznetsov.shop.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Store;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoreRepository extends AbstractRepository<Store> {

    @Query(value = "select stock.* from store " +
            "where (:id is null or store.id = :id) " +
            "and (:name is null or store.name = :name) " +
            "and (:addressId is null or store.address_id = :addressId)" +
            "and (:ownerId is null or store.owner_id = :ownerId)",
            nativeQuery = true)
    List<Store> findAllByOptionalParams(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("addressId") Long addressId,
            @Param("ownerId") UUID ownerId);

    Optional<Store> findByName(String name);
}
