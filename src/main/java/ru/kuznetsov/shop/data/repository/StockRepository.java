package ru.kuznetsov.shop.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Stock;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockRepository extends AbstractRepository<Stock> {

    @Query(value = "select stock.* from stock " +
            "join product on stock.product_id = product.id " +
            "where (:productId is null or stock.product_id = :productId) " +
            "and (:storeId is null or stock.store_id = :storeId) " +
            "and (:ownerId is null or product.owner_id = :ownerId)",
            nativeQuery = true)
    List<Stock> findAllByOptionalParams(
            @Param("productId") Long productId,
            @Param("storeId") Long storeId,
            @Param("ownerId") UUID ownerId);

    List<Stock> findAllByReservationOrderId(Long reservationOrderId);
}
