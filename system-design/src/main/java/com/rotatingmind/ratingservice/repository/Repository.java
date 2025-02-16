package com.rotatingmind.ratingservice.repository;

import com.rotatingmind.ratingservice.domain.SurveyUser;

import java.util.List;
import java.util.Optional;

public interface Repository<T, I> {

    Optional<T> findById(I id);

    List<T> findAll();

    Optional<T> save(T data);

    void delete(I data);

    List<T> findByIds(List<I> ids);

    void saveAll(List<T> datas);
}
