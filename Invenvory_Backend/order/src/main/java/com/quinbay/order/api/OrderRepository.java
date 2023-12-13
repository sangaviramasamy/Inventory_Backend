package com.quinbay.order.api;

 import com.quinbay.order.model.entity.Order;
 import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findAll();

    <S extends Order> List<S> saveAll(Iterable<S> orders);
}
