package com.quinbay.Inventory.model.entity;

import com.quinbay.Inventory.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = FieldNames.PRODUCT_T)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @Column(name = FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FieldNames.NAME, nullable = false)
    private String name;

    @Column(name = FieldNames.PRICE, nullable = false)
    private double price;

    @Column(name = FieldNames.QUANTITY, nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = FieldNames.CATEGORY_ID, nullable = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
