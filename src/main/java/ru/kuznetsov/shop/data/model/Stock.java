package ru.kuznetsov.shop.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "stock")
@Data
@EqualsAndHashCode(callSuper = true)
public class Stock extends AbstractEntity {
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "is_reserved")
    private Boolean isReserved;
    @Column(name = "reservation_order_id")
    private Long reservationOrderId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
