package com.quinbay.order.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.order.api.OrderRepository;
import com.quinbay.order.model.entity.Order;
import com.quinbay.order.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class OrderServiceImple implements OrderService{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository OrderRepository;


    @Override
    public List<Order> getAllOrders() {
         return OrderRepository.findAll();
    }

    @Override
    public String placeOrder(Order order) {
         List<Order> orders = Collections.singletonList(order);

         int id = order.getProductId();
         int quantity = order.getProductQuantity();

        List<ProductVo> prodList = getById(id);

        if (!prodList.isEmpty()) {
            ProductVo prod = prodList.get(0);
            if (prod.getQuantity() > quantity) {

                ObjectMapper objectMapper = new ObjectMapper();
                int quanCheck = prod.getQuantity() - quantity;
                if(quanCheck > 0){
                    prod.setQuantity(order.getProductQuantity());
                    OrderRepository.save(objectMapper.convertValue(order, Order.class));
                    updateProductDb(prod);
                }
                else{
                    return "added";
                }


            } else {
                return "order quantity is limited";
            }
        } else {
            return "product unavailable";
        }

//
//        ProductVo prod = prodList.get(0);

//        if (!prodList.isEmpty()) {
//            int prodQuantity = prod.getQuantity();
//
//
//        } else {
//            return "product unavailable";
//        }


         OrderRepository.saveAll(orders);

         return "Order Placed";
    }



    public String updateProductDb(ProductVo product)
    {
        String baseUrl ="http://localhost:8086/httpmethod/";

        HttpHeaders header=new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity =new HttpEntity<>(product,header);
        System.out.println(entity.getBody());
        return restTemplate.exchange(baseUrl+"/updateProduct",HttpMethod.PUT,entity,String.class).getBody();

    }

    public List<ProductVo> getById(long prodId){
        String baseUrl ="http://localhost:8086/httpmethod/";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity(headers);


        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "getProduct/"+prodId).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }



}
