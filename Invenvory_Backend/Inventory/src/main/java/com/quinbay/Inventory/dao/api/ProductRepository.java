package com.quinbay.Inventory.dao.api;

import com.quinbay.Inventory.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();

    @Override
    Product save(Product prod);

//    @Override
    List<Product> findAllById(Long ids); //list all products

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    void deleteAllInBatch(Iterable<Product>  id);
}


