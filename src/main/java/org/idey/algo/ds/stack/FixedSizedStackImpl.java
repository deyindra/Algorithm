package org.idey.algo.ds.stack;

import java.util.NoSuchElementException;

public class FixedSizedStackImpl<T> implements Stack<T>{
    protected T[] array;
    protected int size;

    public FixedSizedStackImpl(int totalSize) {
        array = (T[])new Object[totalSize];
        size=0;
    }

    protected FixedSizedStackImpl(){

    }

    @Override
    public T pop() {
        if(size==0){
            throw new NoSuchElementException("No more elements");
        }
        size--;
        T object = array[size];
        array[size]=null;
        return object;
    }

    @Override
    public void push(T object) {
        if(size==array.length){
            throw new IllegalArgumentException("Can not add any more element");
        }
        array[size++]=object;
    }

    @Override
    public T top() {
        return array[size];
    }

    @Override
    public int size() {
        return size;
    }
}
