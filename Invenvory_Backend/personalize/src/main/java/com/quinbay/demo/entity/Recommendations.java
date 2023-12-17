package com.quinbay.demo.entity;

import com.quinbay.demo.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = FieldNames.PERSONALIZE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendations {

    @Id
    @Column(name = FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FieldNames.CUSTOMER_ID, nullable = false)
    private int customer_id;

    @Column(name = FieldNames.PRODUCT_ID, nullable = false)
    private int product_id;

}
