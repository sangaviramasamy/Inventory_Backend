package com.quinbay.demo.service;

import com.quinbay.demo.model.vo.RecommendationVo;

import java.util.List;

public interface PersonalizeService {

    List<RecommendationVo> getPersonalizeList();

    List<RecommendationVo> getCustomerById(List<Long> cusId);
}
