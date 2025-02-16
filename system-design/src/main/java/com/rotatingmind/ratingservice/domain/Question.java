package com.rotatingmind.ratingservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Question {
    private Long questionId;
    private String question;
    private List<Option> options = new ArrayList<>();
    private Double rating;
}
