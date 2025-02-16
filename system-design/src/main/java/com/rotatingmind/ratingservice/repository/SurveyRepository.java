package com.rotatingmind.ratingservice.repository;

import com.rotatingmind.ratingservice.domain.Survey;

import java.util.List;
import java.util.Optional;

public class SurveyRepository extends AbstractRepository<Survey, Long>  {

    @Override
    protected Long extractId(Survey data) {
        return data.getSurveyId();
    }

    @Override
    public Optional<Survey> save(Survey data) {
        return super.save(data);
    }

    @Override
    public void delete(Long data) {
        super.delete(data);
    }

    @Override
    public List<Survey> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Survey> findById(Long id) {
        return super.findById(id);
    }
}
