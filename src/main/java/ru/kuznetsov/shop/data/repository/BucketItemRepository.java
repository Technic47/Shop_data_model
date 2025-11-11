package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.order.BucketItem;

@Repository
public interface BucketItemRepository extends AbstractRepository<BucketItem> {
}
