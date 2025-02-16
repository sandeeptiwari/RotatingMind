package com.rotatingmind.ratingservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Option {
    private Long optionId;
    private String optionName;
    private double weightage;
    private Long questionId;
}
