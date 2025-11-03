package ru.kuznetsov.shop.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Stock;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockRepository extends AbstractRepository<Stock> {

    @Query(value = "select * from stock " +
            "join product on stock.product_id = product.id " +
            "where stock.product_id = :productId " +
            "and priduct.owner_id = :ownerId",
            nativeQuery = true)
    List<Stock> findAllByProductIdAndOwnerId(
            @Param("productId") Long productId,
            @Param("ownerId") UUID ownerId);

    List<Stock> findAllByProductId(Long productId);

    List<Stock> findAllByStoreId(Long storeId);
}
