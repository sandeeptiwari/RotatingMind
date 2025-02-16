package com.rotatingmind.ratingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurveyUser {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private UserRole userRole;
    private Set<Long> activeSurvey = new HashSet<>();
    private Set<Long> closedSurvey = new HashSet<>();
}
