package com.quinbay.demo.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.demo.dao.api.PersonalizeRepository;
import com.quinbay.demo.model.vo.RecommendationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalizeServiceImpl implements PersonalizeService {

    @Autowired
    PersonalizeRepository personalizeRepository;

    @Override
    public List<RecommendationVo> getPersonalizeList(){
        List<com.quinbay.demo.entity.Recommendations> productList = personalizeRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(productList,List.class);
    }

    @Override
    public List<RecommendationVo> getCustomerById(List<Long> cusId){

        List<com.quinbay.demo.entity.Recommendations> productList = personalizeRepository.findAllById(cusId);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(productList,List.class);

    }



}
