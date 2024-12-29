package com.rotatingmind.hackthon.domain;

import lombok.Data;

@Data
public class Problem {
    private Long id;
    private String name;
    private String tag;
    private ProblemType level;
    private Integer score;
    private Integer like;
}
