package com.rotatingmind.ratingservice.repository;

import com.rotatingmind.ratingservice.domain.SurveyUser;

import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<SurveyUser, Long> {

    @Override
    public Optional<SurveyUser> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<SurveyUser> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<SurveyUser> save(SurveyUser data) {
        return super.save(data);
    }

    @Override
    public void delete(Long data) {
        super.delete(data);
    }

    @Override
    protected Long extractId(SurveyUser data) {
        return data.getUserId();
    }
}
