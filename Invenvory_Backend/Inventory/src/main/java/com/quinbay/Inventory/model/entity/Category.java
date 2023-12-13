package com.quinbay.Inventory.model.entity;

import com.quinbay.Inventory.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;


@Entity
@Table(name = FieldNames.CATEGORY_T)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @Column(name = FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FieldNames.NAME, nullable = false)
    private String name;

//    @OneToMany
//    @JoinColumn(name = FieldNames.ID, nullable = false)
//    private Category category;

}
