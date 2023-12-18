package com.codecademy.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    // @Column(name = "USER")
    // private String userId;
    // @OneToOne(targetEntity = User.class)
    // private User user;
    @Column(name = "REVIEW_PEANUT")
    private Double reviewPeanut;
    @Column(name = "REVIEW_EGG")
    private Double reviewEgg;
    @Column(name = "REVIEW_DAIRY")
    private Double reviewDairy;
    @Column(name = "RESTAURANT_SCORE")
    private Double restaurantScore;
}
