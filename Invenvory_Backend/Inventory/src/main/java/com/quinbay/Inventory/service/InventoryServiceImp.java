package com.quinbay.Inventory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.Inventory.controller.Inventory;
import com.quinbay.Inventory.dao.api.ProductRepository;
import com.quinbay.Inventory.model.entity.Product;
import com.quinbay.Inventory.model.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

//import static org.springframework.boot.env.ConfigTreePropertySource.PropertyFile.findAll;

@Service
public class InventoryServiceImp implements InventoryService{

    @Autowired
    ProductRepository productRepository;


//    @KafkaListener(topics="com.quinbay.product.create",groupId = "group-id")
//    public void getinfo(String info) throws JsonProcessingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        Inventory resProduct=objectMapper.readValue(info,Inventory.class);
//        System.out.println("Received message in group - group-id "+ info);
//    }

//    @KafkaListener(topics="com.quinbay.product.create",groupId = "group-id")
//    public void listen(String message) throws JsonProcessingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        Inventory resProduct=objectMapper.readValue(message,Inventory.class);
//        System.out.println("Received message in group - group-id "+resProduct.getProduct_price());
//
//    }
    @Override
    @Cacheable(value = "springBoot",key = "#key")
    public String getRedis(String key,String value){
        return value;
    }

    @KafkaListener(topics = "com.quinbay.product.create", groupId = "group-id")
    public void listen(String message){
        System.out.println("Received message in group - group-id " + message);
    }

    @Override
    public String sendProductList(ProductVo product){

            ObjectMapper objectMapper = new ObjectMapper();
            productRepository.save(objectMapper.convertValue(product, com.quinbay.Inventory.model.entity.Product.class));
            return "product added successfully";

    }



    @Override
    public  List<ProductVo> getProductList(){
        List<com.quinbay.Inventory.model.entity.Product> productList = productRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(productList,List.class);
    }

    @Override
    public String addProduct(ProductVo prod) {
        ObjectMapper objectMapper = new ObjectMapper();
        productRepository.save(objectMapper.convertValue(prod, com.quinbay.Inventory.model.entity.Product.class));
        return "Product Added";
    }


    @Override
    public List<Product> getProductsById(List<Long> productIds) {
        System.out.println("product ids : " + productIds);
        return productRepository.findAllById(productIds);
    }

    @Override
    public List<Product> getProductById(Long productId) {
        System.out.println("product ids : " + productId);
        return productRepository.findAllById(productId);
    }
    @Override
    public String updateProductList(ProductVo product)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        productRepository.save(objectMapper.convertValue(product, com.quinbay.Inventory.model.entity.Product.class));

        return "product updated";
    }
    @Override
    public String deleteProductById(Long prodId) {
        Product p = new Product();
        p.setId(prodId);
        productRepository.deleteAllInBatch(Arrays.asList(p));
        return "deleted";
    }



    public List<Inventory> setProductDetails( Inventory product){
        List<Inventory> productList = new ArrayList<>();

        Inventory product1 =new Inventory();
        product1.setProd_id(1);
        product1.setProduct_name("Maths");
        product1.setProduct_price(100);
        product1.setCategory("book");
        productList.add(product1);

        Inventory product2 =new Inventory();
        product2.setProd_id(1);
        product2.setProduct_name("Tamil");
        product2.setProduct_price(150);
        product2.setCategory("book");
        productList.add(product2);

        return productList;

    }

    public List<Inventory> getproduct(String category)
    {
        List<Inventory> productList = new ArrayList<>();

        List<Inventory> productList2 = new ArrayList<>();

        Inventory product1 =new Inventory();
        product1.setProd_id(1);
        product1.setProduct_name("Maths");
        product1.setProduct_price(100);
        product1.setCategory("book");
        productList.add(product1);

        Inventory product2 =new Inventory();
        product2.setProd_id(1);
        product2.setProduct_name("Tamil");
        product2.setProduct_price(150);
        product2.setCategory("vsc");
        productList.add(product2);

        Iterator<Inventory> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Inventory product = iterator.next();
            if (product.getCategory() == category) {
                productList2.add(product);
            }
        }


        return productList;
    }

    public String deleteProductDetails(int prodId)
    {
        List<Inventory> productList = new ArrayList<>();

        Inventory product1 =new Inventory();
        product1.setProd_id(1);
        product1.setProduct_name("Maths");
        product1.setProduct_price(100);
        product1.setCategory("book");
        productList.add(product1);

        Inventory product2 =new Inventory();
        product2.setProd_id(1);
        product2.setProduct_name("Tamil");
        product2.setProduct_price(150);
        product2.setCategory("book");
        productList.add(product2);


        Iterator<Inventory> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Inventory product = iterator.next();
            if (product.getProd_id() == prodId) {
                iterator.remove();
                return("Product with prodid " + prodId + " deleted");
            }
        }

        return ("Product not found");
    }

}


