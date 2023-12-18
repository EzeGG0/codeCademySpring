package com.codecademy.project.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "RESTAURANT")
@Getter @Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "REVIEW_PEANUT")
    private Double reviewPeanut;
    @Column(name = "REVIEW_EGG")
    private Double reviewEgg;
    @Column(name = "REVIEW_DAIRY")
    private Double reviewDairy;
    @Column(name = "RESTAURANT_SCORE")
    private Double restaurantScore;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<DinnerReview> dinnerReviews;
}
