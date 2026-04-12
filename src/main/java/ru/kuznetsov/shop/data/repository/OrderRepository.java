package ru.kuznetsov.shop.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.order.Order;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends AbstractRepository<Order> {

    List<Order> getAllByCustomerId(UUID customerId);

    @Query("SELECT o FROM Order o " +
            "WHERE (CAST(:customerId AS uuid)IS NULL OR o.customerId = :customerId) " +
            "  AND (CAST(:dateAfter AS localdatetime) IS NULL OR o.created >= :dateAfter) " +
            "  AND (CAST(:dateBefore AS localdatetime) IS NULL OR o.created < :dateBefore) " +
            "  AND EXISTS (SELECT 1 FROM OrderStatus os WHERE os.orderId = o.id AND os.status = :hasStatus) " +
            "  AND NOT EXISTS (SELECT 1 FROM OrderStatus os WHERE os.orderId = o.id AND os.status = :hasNotStatus)")
    List<Order> getAllByHavingStatusAndNotHavingOther(
            @Param("customerId") UUID customerId,
            @Param("dateAfter") LocalDateTime dateAfter,
            @Param("dateBefore") LocalDateTime dateBefore,
            @Param("hasStatus") OrderStatusType hasStatus,
            @Param("hasNotStatus") OrderStatusType hasNotStatus
    );
}
