package com.codecademy.project.entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "PAGE_USERS")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "NAME", unique = true)
    private String name;

    @NonNull
    @Column(name = "CITY")
    private String city;

    @NonNull
    @Column(name = "STATE")
    private String state;

    @NonNull
    @Column(name = "ZIPCODE")
    private Integer zipcode;

    @Column(name = "INTERESTED_IN_PEANUT")
    private Boolean interestedInPeanut;

    @Column(name = "INTERESTED_IN_EGG")
    private Boolean interestedInEgg;

    @Column(name = "INTERESTED_IN_DAIRY")
    private Boolean interestedInDairy;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DinnerReview> dinnerReviews;

}