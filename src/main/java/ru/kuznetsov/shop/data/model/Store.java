package ru.kuznetsov.shop.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Table(name = "store")
@Data
@EqualsAndHashCode(callSuper = true)
public class Store extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "owner_id")
    private UUID owner;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
