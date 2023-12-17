package com.quinbay.customer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quinbay.customer.service.CustomerServices;
import com.quinbay.customer.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/httpmethod")
public class CustomerController {

    @Autowired
    CustomerServices customerInterface;


    @PostMapping("/addToDb")
    public String addDb(@RequestBody Customer p)
    {
        return customerInterface.addProductDb(p);
    }

    @PutMapping("updateDb")
    public String updateDb(@RequestBody ProductVo product)
    {
        return customerInterface.updateProductDb(product);
    }

    @DeleteMapping("/deleteToDb")
    public String deletedb(@RequestParam(value="id") int prodId){
        return customerInterface.deleteProductDb(prodId);
    }

    @GetMapping("/getById")
    public List<ProductVo> getProductById(@RequestParam(value="id") long prodId)
    {
        return customerInterface.getById(prodId);
    }

    @GetMapping("/prod/{productCategory}")
    public List<Customer> getProductByCategory(@PathVariable String productCategory)
    {
        return customerInterface.getProductByCategory(productCategory);
    }


    @PostMapping("/add")
    public String addProductDetails(@RequestBody Customer p)
    {
        return customerInterface.addProductDetails(p);
    }



    @DeleteMapping("/products/delete")
    public String deleteProductDetails(@RequestBody int prodId)
    {
        return customerInterface.deleteProductDetails(prodId);
    }

    @PostMapping("/publish")
    public void publishKafka(){
        customerInterface.sendMessage("Hi");
    }

    @PostMapping("/publish/send")
    public void sendKafka(@RequestBody Customer c) throws JsonProcessingException {
        customerInterface.send(c);

    }
}




