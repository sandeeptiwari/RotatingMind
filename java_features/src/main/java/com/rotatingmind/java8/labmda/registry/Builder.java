package com.rotatingmind.java8.labmda.registry;

import com.rotatingmind.java8.labmda.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
