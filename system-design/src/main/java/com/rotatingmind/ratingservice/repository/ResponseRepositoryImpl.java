package com.rotatingmind.ratingservice.repository;

import com.rotatingmind.ratingservice.domain.Answer;
import com.rotatingmind.ratingservice.domain.Response;

import java.util.*;
import java.util.stream.Collectors;

public class ResponseRepositoryImpl extends AbstractRepository<Response, Long> implements ResponseRepository {

    protected final Map<Long, List<Response>> responseById = new HashMap<>();
    protected final Map<Long, List<Response>> responseByQuestionId = new HashMap<>();

    @Override
    public Optional<Response> save(Response data) {
        super.save(data);  // First save it to the generic map

        // Store it in the specialized surveyId map
        responseById.computeIfAbsent(data.getSurveyId(), k -> new ArrayList<>()).add(data);

        return Optional.ofNullable(data);
    }

    @Override
    protected Long extractId(Response data) {
        return data.getResId();
    }

    @Override
    public List<Response> findBySurveyId(Long surveyId) {
        return responseById.getOrDefault(surveyId, Collections.emptyList());
    }

}
