package com.rotatingmind.ratingservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Survey {
    private Long surveyId;
    private String name;
    private double rating;
    private long createdAt;
    private long updatedAt;
    private long createdBy;
    private List<Question> questions;
    private boolean isActive;
}
