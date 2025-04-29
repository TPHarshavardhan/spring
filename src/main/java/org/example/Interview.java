package org.example;

@FunctionalInterface
public interface Interview<T> {

    T check(T x);
}
