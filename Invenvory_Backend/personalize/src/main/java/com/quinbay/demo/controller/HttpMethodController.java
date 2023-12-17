package com.quinbay.demo.controller;

import com.quinbay.demo.model.vo.RecommendationVo;
import com.quinbay.demo.service.PersonalizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/httpmethod")
public class HttpMethodController {

    @Autowired
    PersonalizeService PersonalizeService;

    //db connection
    @GetMapping("/getAll")
    public List<RecommendationVo> getPersonalize()
    {
        return PersonalizeService.getPersonalizeList();
    }


//    @GetMapping("getCustomer/{cusId}")
//    public List<RecommendationVo> getById(
//            @PathVariable("cusId") Long cusId){
//        return PersonalizeService.getCustomerById(cusId);
//    }
    @GetMapping("getCustomer/{cusId}")
    public List<RecommendationVo> getById(
            @PathVariable("cusId") Long cusId){
        // Convert the single cusId to a List<Long>
        List<Long> cusIdList = Collections.singletonList(cusId);
        return PersonalizeService.getCustomerById(cusIdList);
    }

}
