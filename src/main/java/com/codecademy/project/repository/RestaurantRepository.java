package com.codecademy.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.project.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    
}
