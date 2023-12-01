package com.rotatingmind.carrental.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Review {
    private Long id;

    private Long reviewerId;

    private Long carId;

    private String reviewDetail;

    private LocalDateTime reviewedAt;

    private LocalDateTime updatedAt;

}
