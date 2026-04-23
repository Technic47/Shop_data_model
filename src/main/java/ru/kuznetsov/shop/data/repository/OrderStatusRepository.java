package ru.kuznetsov.shop.data.repository;

import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.order.OrderStatus;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderStatusRepository extends AbstractRepository<OrderStatus> {

    List<OrderStatus> getAllByOrderId(Long orderId);

    List<OrderStatus> getAllByStatus(OrderStatusType status);

    List<OrderStatus> getAllByStatusAndCreatedAfter(OrderStatusType status, LocalDateTime dateTimeAfter, Limit limit);

    List<OrderStatus> getAllByStatusAndCreatedBefore(OrderStatusType status, LocalDateTime dateTimeBefore, Limit limit);
}
