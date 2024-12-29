package com.rotatingmind.hackthon.repo;

import java.util.List;

public interface Repository<T, I> {

    T save(T t);

    T findById(I id);

    List<T> findAll();
}
