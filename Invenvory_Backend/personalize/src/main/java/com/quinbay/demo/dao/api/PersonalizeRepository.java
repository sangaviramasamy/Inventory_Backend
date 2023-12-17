package com.quinbay.demo.dao.api;

import com.quinbay.demo.entity.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalizeRepository extends JpaRepository<Recommendations,Long> {

    @Override
    List<Recommendations> findAll();
    List<Recommendations> findAllById(List<Long> ids);
}
