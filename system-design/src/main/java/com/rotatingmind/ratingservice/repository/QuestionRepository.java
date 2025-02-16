package com.rotatingmind.ratingservice.repository;

import com.rotatingmind.ratingservice.domain.Question;

import java.util.List;
import java.util.Optional;

public class QuestionRepository extends AbstractRepository<Question, Long> {

    @Override
    public Optional<Question> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Question> findByIds(List<Long> ids) {
        return super.findByIds(ids);
    }

    @Override
    public List<Question> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Question> save(Question data) {
        return super.save(data);
    }

    @Override
    public void delete(Long data) {
        super.delete(data);
    }

    @Override
    protected Long extractId(Question data) {
        return data.getQuestionId();
    }
}
