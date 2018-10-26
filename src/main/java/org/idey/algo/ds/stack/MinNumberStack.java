package org.idey.algo.ds.stack;


public class MinNumberStack<T extends Comparable<T>> extends FixedSizedStackImpl<T> {
    private FixedSizedStackImpl<T> minStack;
    private FixedSizedStackImpl<T> maxStack;

    public MinNumberStack(int totalSize) {
        array = (T[])new Object[totalSize];
        size=0;
        minStack = new FixedSizedStackImpl<>(size);
        maxStack = new FixedSizedStackImpl<>(size);
    }

    @Override
    public T pop() {
        T object = super.pop();
        T min = minStack.top();
        T max = maxStack.top();

        if(object.equals(min)){
            minStack.pop();
        }

        if(object.equals(max)){
            maxStack.pop();
        }
        return object;
    }

    @Override
    public void push(T object) {
        super.push(object);
        if(size==0){
            minStack.push(object);
            maxStack.push(object);
        }else{
            T min = minStack.top();
            T max = maxStack.top();
            if(object.compareTo(min)<=0){
                minStack.push(object);
            }
            if(object.compareTo(max)>=0){
                maxStack.push(object);
            }
        }
    }


}
