package com.codecademy.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.project.entity.DinnerReview;

public interface DinningRepository extends CrudRepository<DinnerReview, Long>{
    
}
