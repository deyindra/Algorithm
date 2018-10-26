package org.idey.algo.ds.stack;

public interface Stack<T> {
    void push(T object);
    T pop();
    T top();
    int size();
}
