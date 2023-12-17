package com.quinbay.order.controller;

import com.quinbay.order.api.OrderRepository;
import com.quinbay.order.model.entity.Order;
import com.quinbay.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/httpmethod")
@CrossOrigin(origins="*")
public class OrderController {

    @Autowired
    OrderService oredrRepository;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return oredrRepository.getAllOrders();
    }

    @PostMapping("/placeOrder")
    public String saveProductDetails(@RequestBody Order ord){

        return oredrRepository.placeOrder(ord);
    }

}
