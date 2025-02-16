package com.rotatingmind.ratingservice.repository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractRepository <T, I> implements Repository<T, I> {
    protected final Map<I, T> dataByIds = new HashMap<>();

    @Override
    public Optional<T> findById(I id) {
        return Optional.ofNullable(dataByIds.get(id));
    }

    @Override
    public List<T> findByIds(List<I> ids) {
        return dataByIds.entrySet().stream()
                .filter(entry -> ids.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(dataByIds.values());
    }

    @Override
    public Optional<T> save(T data) {

        if (data == null) {
            return Optional.empty();
        }

        I id = extractId(data);
        dataByIds.put(id, data);
        return Optional.of(data); // No need for `ofNullable` since `data` is never null
    }

    @Override
    public void saveAll(List<T> datas) {

        if (datas == null || datas.isEmpty()) {
            return; // No need to process if the list is empty
        }

        Map<I, T> batchInsert = datas.stream()
                .collect(Collectors.toMap(this::extractId, Function.identity(), (existing, replacement) -> replacement));

        dataByIds.putAll(batchInsert); // Efficient batch insert into the map
    }

    @Override
    public void delete(I id) {
        dataByIds.remove(id);
    }

    // Abstract method to get the ID from the entity
    protected abstract I extractId(T data);
}
