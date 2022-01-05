package com.rotatingmind.java16.record;


public record Range(int lo, int hi) {
    public Range {
        if (lo > hi)  // referring here to the implicit constructor parameters
            throw new IllegalArgumentException(String.format("(%d,%d)", lo, hi));
    }
}
