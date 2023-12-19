package com.codecademy.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.project.entity.Restaurant;
import java.util.List;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    List<Restaurant> findByName(String name);
}
