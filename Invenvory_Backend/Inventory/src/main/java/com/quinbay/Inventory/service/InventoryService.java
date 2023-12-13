package com.quinbay.Inventory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quinbay.Inventory.controller.Inventory;
import com.quinbay.Inventory.model.entity.Product;
import com.quinbay.Inventory.model.vo.ProductVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface InventoryService {



    public List<Inventory> setProductDetails(Inventory product);

    public List<Inventory> getproduct(String category);

    public String deleteProductDetails(int prodId);

    public String updateProductList(ProductVo product);

    public List<Product> getProductById(Long productId);

    public List<ProductVo> getProductList();

    public String addProduct(ProductVo prod);//add product

    public List<Product> getProductsById(List<Long> productIds);


    public String deleteProductById(Long prodId);

    public String sendProductList(ProductVo product);

    public String getRedis(String key, String details);



}


