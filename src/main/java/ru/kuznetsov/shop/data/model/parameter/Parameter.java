package ru.kuznetsov.shop.data.model.parameter;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "parameter")
@Data
@EqualsAndHashCode(callSuper = false)
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "key", unique = true)
    private String key;
    @Column(name = "value")
    private String value;
    @Column(name = "comment")
    private String comment;
}
