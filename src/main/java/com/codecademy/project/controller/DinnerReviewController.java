package com.codecademy.project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.codecademy.project.entity.DinnerReview;
import com.codecademy.project.entity.Restaurant;
import com.codecademy.project.entity.User;
import com.codecademy.project.repository.DinningRepository;
import com.codecademy.project.repository.RestaurantRepository;
import com.codecademy.project.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class DinnerReviewController {
    @Autowired
    private DinningRepository dinnerReviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;


    @GetMapping("/api/allReviews")
    public ResponseEntity<Iterable<DinnerReview>> getAllReviews() {
        Iterable<DinnerReview> allDinnerReview = dinnerReviewRepository.findAll();
        return ResponseEntity.ok(allDinnerReview);
    }
    
    @PostMapping("/api/user/{id}/restaurant/{idRestaurant}/postReview")
    public ResponseEntity<DinnerReview> postDinnerReview(
        @RequestBody DinnerReview newDinnerReview, 
        @PathVariable(name = "id") Long id, 
        @PathVariable(name = "idRestaurant") Long idRestaurant) 
        {
            Optional<User> actualUserOptional = userRepository.findById(id);
            Optional<Restaurant> actualRestaurantOptional = restaurantRepository.findById(idRestaurant);

            if (!actualUserOptional.isPresent()) {
                return ResponseEntity.badRequest().build();
            }

            if (!actualRestaurantOptional.isPresent()) {
                return ResponseEntity.badRequest().build();
            }

            User actualUser = actualUserOptional.get();
            Restaurant actualRestaurant = actualRestaurantOptional.get();
            newDinnerReview.setUser(actualUser);
            newDinnerReview.setRestaurant(actualRestaurant);
            newDinnerReview.setUsername(actualUser.getName());
            DinnerReview newReview;

            try {
                newReview = dinnerReviewRepository.save(newDinnerReview);
            } catch (Exception e) {
                // Handle exceptions appropriately, log details
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.ok(newReview);
    }

    @PutMapping("/api/review/{id}")
    public ResponseEntity<DinnerReview> putReview(
        @PathVariable Long id,
        @RequestBody DinnerReview updatedDinnerReview
        ) 
        {
            Optional<DinnerReview> actualDinnerReviewOptional = dinnerReviewRepository.findById(id);

            if (!actualDinnerReviewOptional.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            
            DinnerReview updateReview = actualDinnerReviewOptional.get();

            if(updatedDinnerReview.getEggScore() != null) {
                updateReview.setEggScore(updatedDinnerReview.getEggScore());
            }
            if(updatedDinnerReview.getPeanutScore() != null) {
                updateReview.setPeanutScore(updatedDinnerReview.getPeanutScore());
            }
            if(updatedDinnerReview.getDairyScore() != null) {
                updateReview.setDairyScore(updatedDinnerReview.getDairyScore());
            }
            if(updatedDinnerReview.getCommentary() != null) {
                updateReview.setCommentary(updatedDinnerReview.getCommentary());
            }
            dinnerReviewRepository.save(updateReview);
            return ResponseEntity.ok(updateReview);
        }
}

