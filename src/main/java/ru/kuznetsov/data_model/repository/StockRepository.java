package ru.kuznetsov.data_model.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.data_model.model.Stock;

import java.util.List;

@Repository
public interface StockRepository extends AbstractRepository<Stock> {

    List<Stock> findAllByProductId(Long productId);

    List<Stock> findAllByStoreId(Long storeId);
}
