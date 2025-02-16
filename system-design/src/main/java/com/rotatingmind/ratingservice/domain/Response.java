package com.rotatingmind.ratingservice.domain;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private Long resId;
    private Long userId;
    private Long surveyId;
    private List<Answer> answers;

}
