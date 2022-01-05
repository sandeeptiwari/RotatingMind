package com.rotatingmind.timeoutcache.model;

import java.time.LocalDateTime;

public interface CacheValue<V> {

    V getValue();

    LocalDateTime getCreatedAt();
}
