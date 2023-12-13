package com.quinbay.customer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.customer.controller.Customer;
import com.quinbay.customer.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;


@Service
public class CustomerServiceImp implements CustomerServices {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    RestTemplate restTemplate;
    private String baseUrl ="http://localhost:8086/httpmethod/";


    public String addProductDb(Customer p)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> entity = new HttpEntity<>(p, headers);

//        ObjectMapper objectMapper = new ObjectMapper();
//        String str = "";
//        try {
//            str = objectMapper.writeValueAsString(p);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        HttpEntity<String> entity1 = new HttpEntity<String>(str, headers);


        String body = restTemplate.exchange(baseUrl + "/addProduct", HttpMethod.POST, entity, String.class).getBody();
        return body;
    }

    public String updateProductDb(ProductVo product)
    {
        HttpHeaders header=new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity =new HttpEntity<>(product,header);
        System.out.println(entity.getBody());
        return restTemplate.exchange(baseUrl+"/updateProduct",HttpMethod.PUT,entity,String.class).getBody();

    }

    public String deleteProductDb(int productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/deleteProduct/{id}")
                .buildAndExpand(productId)
                .encode();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, entity, String.class).getBody();
    }



    public String addProductDetails(Customer p)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> entity = new HttpEntity<>(p, headers);
        return restTemplate.exchange( baseUrl +"/products/set", HttpMethod.POST, entity, String.class).getBody();
    }

    public List<Customer> getProductByCategory(String category){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl +"products/getCategory").queryParam("category", category).build();

        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();

    }

    public List<ProductVo> getById(long prodId){
//        System.out.println("ssssss");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity(headers);
        //UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl +"/getProduct/").queryParam("prodId", prodId).build();
//        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/getProduct/"+prodId)
//                .buildAndExpand(prodId)
//                .encode();


        //return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "getProduct/"+prodId).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();


    }


    public String deleteProductDetails(int productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/products/delete").queryParam("id", productId).build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, entity, String.class).getBody();
    }



    @Override
    public void sendMessage(String msg){
        kafkaTemplate.send("com.quinbay.product.create",msg);
    }

    @Override
    public void send(Customer c) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String details = objectMapper.writeValueAsString(c);
        kafkaTemplate.send("sending",details);
    }

}
