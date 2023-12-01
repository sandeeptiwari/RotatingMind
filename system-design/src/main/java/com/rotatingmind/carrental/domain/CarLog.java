package com.rotatingmind.carrental.domain;

import com.rotatingmind.carrental.domain.enums.CarLogType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarLog {
    private Long id;

    private CarLogType logType;


    private String logDescription;

    private LocalDateTime loggedAt;

}
