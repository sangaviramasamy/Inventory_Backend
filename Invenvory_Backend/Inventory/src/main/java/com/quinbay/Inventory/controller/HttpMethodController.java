package com.quinbay.Inventory.controller;

import com.quinbay.Inventory.model.entity.Product;
import com.quinbay.Inventory.model.vo.ProductVo;
import com.quinbay.Inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/httpmethod")
@CrossOrigin(origins="*")
public class HttpMethodController {

    @Autowired
    InventoryService ProductServices;



    //db connection
    @GetMapping("getAllProduct")
    public List<ProductVo> getProductDetails() {
        return ProductServices.getProductList();
    }

    @GetMapping("getProduct/{prodId}")
    public List<Product> getById(
            @PathVariable("prodId") Long prodId){
        return ProductServices.getProductById(prodId);
    }

    @PostMapping("addProduct")
    public String addProductDetails(@RequestBody ProductVo p) {
        return ProductServices.addProduct(p);
    }

    @PutMapping(value= "/updateProduct")
    public String updateDetails(@RequestBody ProductVo product)
    {
        return ProductServices.updateProductList(product);
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteById(
            @PathVariable("id") Long id){
        return ProductServices.deleteProductById(id);
    }

    @GetMapping("/products/get")
    public List<Product> getproduct(@RequestParam long prodId)
    {
        return ProductServices.getProductById(prodId);
    }

    @GetMapping("/products/getCategory")
    public List<Inventory> getproduct(@RequestParam String category)
    {
        return ProductServices.getproduct(category);
    }

    @GetMapping("/redisCache")
    public String getRedis(@RequestParam String key, String details){
        return ProductServices.getRedis(key,details);
    }

}
