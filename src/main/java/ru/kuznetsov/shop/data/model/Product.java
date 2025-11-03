package ru.kuznetsov.shop.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Column(name = "owner_id")
    private UUID owner;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
}
