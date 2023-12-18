package com.codecademy.project.entity;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminReview {
    @NonNull
    private Boolean approved;

}
    

