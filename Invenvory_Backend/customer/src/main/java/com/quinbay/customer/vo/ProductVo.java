package com.quinbay.customer.vo;

import com.quinbay.customer.controller.Category;
import com.quinbay.customer.controller.Category;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
