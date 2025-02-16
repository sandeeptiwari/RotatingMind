package com.rotatingmind.ratingservice.repository;

import com.rotatingmind.ratingservice.domain.Response;

import java.util.*;


public interface ResponseRepository  {

    List<Response> findBySurveyId(Long surveyId);

}
