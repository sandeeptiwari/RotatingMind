package com.rotatingmind.ratingservice.domain;

import lombok.Data;

@Data
public class Answer {
    private Long id;
    private Long questionId;
    private Long optionId;      // ID of the selected option
    private Double weightage;
    private String answerText;  // The actual answer (can be optional depending on your requirements)
}
