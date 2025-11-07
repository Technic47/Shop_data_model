package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.order.OrderStatus;

import java.util.List;

@Repository
public interface OrderStatusRepository extends AbstractRepository<OrderStatus> {

    List<OrderStatus> getAllByOrderId(Long orderId);
}
