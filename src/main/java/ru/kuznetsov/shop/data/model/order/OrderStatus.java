package ru.kuznetsov.shop.data.model.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kuznetsov.shop.data.model.AbstractEntity;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.util.UUID;

@Entity
@Table(name = "shop_order_status")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderStatus extends AbstractEntity {
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusType status;
    @Column(name = "status_changer_id")
    private UUID statusChangerId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "order_id")
    private Long orderId;
}
