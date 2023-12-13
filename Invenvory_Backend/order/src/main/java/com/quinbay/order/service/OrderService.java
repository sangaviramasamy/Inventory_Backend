package com.quinbay.order.service;

import com.quinbay.order.model.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    String placeOrder(Order p);
}
