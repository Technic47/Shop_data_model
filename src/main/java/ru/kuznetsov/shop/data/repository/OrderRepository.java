package ru.kuznetsov.shop.data.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.order.Order;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends AbstractRepository<Order> {

    List<Order> getAllByCustomerId(UUID customerId);
}
