package com.codecademy.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.codecademy.project.enums.ReviewStatus;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "DINNER_REVIEW")
@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class DinnerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    @NonNull
    private String username;
    @Column(name = "RESTAURANT_REVIEW")
    @NonNull
    private Long restaurantReview;
    @Column(name = "PEANUT_SCORE")
    private Integer peanutScore;
    @Column(name = "EGG_SCORE")
    private Integer eggScore;
    @Column(name = "DAIRY_SCORE")
    private Integer dairyScore;
    @Column(name = "COMMENTARY")
    private String commentary;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING) // Specify enum storage strategy
    private ReviewStatus status; // New addition - review status

    @ManyToOne
    @JoinColumn(name = "USER_ID") // Maps to User ID column in DinnerReview
    private User user;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;
}
