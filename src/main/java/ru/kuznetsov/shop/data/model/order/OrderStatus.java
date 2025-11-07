package ru.kuznetsov.shop.data.model.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kuznetsov.shop.data.model.AbstractEntity;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderStatus extends AbstractEntity {
    @Column(name = "status")
    private OrderStatusType status;
    @Column(name = "status_changer_id")
    private UUID statusChangerId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "order_id")
    private Long orderId;
}
