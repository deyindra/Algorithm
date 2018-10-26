package org.idey.algo.iterator.generic;

public abstract class AbstractFibonacciIteratorTest<T extends Number & Comparable<T>> {
    protected T start;
    protected T end;
    protected AbstractFibonacciIteratorTest(T start, T end) {
        this.start = start;
        this.end = end;
    }
}
