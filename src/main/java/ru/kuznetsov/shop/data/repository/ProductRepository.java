package ru.kuznetsov.shop.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends AbstractRepository<Product> {

    List<Product> findAllByOwner(UUID ownerId);

    @Query(value = "select product.* from product " +
            "where (:ownerId is null or product.owner_id = :ownerId) " +
            "and (:categoryId is null or product.category_id = :categoryId) ",
            nativeQuery = true)
    List<Product> findAllByOwnerIdOrCategory(
            @Param("ownerId") UUID ownerId,
            @Param("categoryId") Long categoryId);

    @Query(value = "select product.owner_id from product " +
            "where product.id = :id",
            nativeQuery = true)
    String getOwnerId(Long id);
}
