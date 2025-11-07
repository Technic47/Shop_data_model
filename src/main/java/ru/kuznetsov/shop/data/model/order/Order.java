package ru.kuznetsov.shop.data.model.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kuznetsov.shop.data.model.AbstractEntity;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.represent.enums.DeliveryType;
import ru.kuznetsov.shop.represent.enums.PaymentType;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "order")
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractEntity {

    @Column(name = "customer_id")
    private UUID customerId;
    @Column(name = "total_sum")
    private Long totalSum;
    @Column(name = "delivery_type")
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Column(name = "customer_delivery_address")
    private String customerDeliveryAddress;
    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address deliveryAddress;
    @ManyToMany
    private Set<Product> products;
    @OneToMany
    private Set<OrderStatus> statusList;
}
