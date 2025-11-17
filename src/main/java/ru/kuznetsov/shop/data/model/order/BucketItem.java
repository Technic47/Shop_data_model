package ru.kuznetsov.shop.data.model.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kuznetsov.shop.data.model.AbstractEntity;

import java.util.UUID;

@Entity
@Table(name = "shop_bucket_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class BucketItem extends AbstractEntity {
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "customer_id")
    private UUID customerId;
}
