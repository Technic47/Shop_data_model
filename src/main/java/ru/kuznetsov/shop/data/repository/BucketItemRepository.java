package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.order.BucketItem;

import java.util.List;
import java.util.UUID;

@Repository
public interface BucketItemRepository extends AbstractRepository<BucketItem> {

    List<BucketItem> getAllByCustomerId(UUID customerId);

    List<BucketItem> getAllByOrderId(Long orderId);
}
