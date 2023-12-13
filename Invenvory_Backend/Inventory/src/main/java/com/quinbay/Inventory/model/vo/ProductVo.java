package com.quinbay.Inventory.model.vo;

import com.quinbay.Inventory.model.entity.Category;
import lombok.Data;

@Data
public class ProductVo {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private Category category;

//    @Override
//    public String toString() {
//        return super.toString() + "toString Overriden";
//    }


}
