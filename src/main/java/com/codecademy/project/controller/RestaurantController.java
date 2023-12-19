package com.codecademy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.project.entity.Restaurant;
import com.codecademy.project.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public ResponseEntity<Iterable<Restaurant>> getallRestaurants() {
        Iterable<Restaurant> allRestaurants = restaurantRepository.findAll();
        return ResponseEntity.ok(allRestaurants);
    }
    
}
