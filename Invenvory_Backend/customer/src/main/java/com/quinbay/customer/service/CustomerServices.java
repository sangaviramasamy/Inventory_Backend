package com.quinbay.customer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quinbay.customer.controller.Customer;
import com.quinbay.customer.vo.ProductVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CustomerServices {

    String addProductDb(Customer p);

    String updateProductDb(ProductVo product);

    String deleteProductDb(int id);

    List<ProductVo> getById(long prodId);

    String addProductDetails(Customer p);

    List<Customer> getProductByCategory(String category);

    String deleteProductDetails(int prodId);

    void sendMessage(String msg);

    void send(Customer c) throws JsonProcessingException;

}
