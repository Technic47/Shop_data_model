package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.Stock;

import java.util.List;

@Repository
public interface StockRepository extends AbstractRepository<Stock> {

    List<Stock> findAllByProductId(Long productId);

    List<Stock> findAllByStoreId(Long storeId);
}
