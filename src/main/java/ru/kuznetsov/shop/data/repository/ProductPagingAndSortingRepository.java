package ru.kuznetsov.shop.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Product;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ProductPagingAndSortingRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value = "select product.* from product " +
            "where (:ownerId is null or product.owner_id = :ownerId) " +
            "and (:categoryId is null or product.category_id = :categoryId) ",
            nativeQuery = true)
    Page<Product> findAllByOwnerIdOrCategoryPageable(
            @Param("ownerId") UUID ownerId,
            @Param("categoryId") Long categoryId,
            Pageable pageable);

    @Query(value = "select product.* from product " +
            "where (:ownerId is null or product.owner_id = :ownerId) " +
            "and (:categoryId is null or product.category_id = :categoryId) ",
            nativeQuery = true)
    Collection<Product> findAllByOwnerIdOrCategory(
            @Param("ownerId") UUID ownerId,
            @Param("categoryId") Long categoryId);
}
