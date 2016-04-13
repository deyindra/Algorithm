package org.idey.algo.iterator.generic;


import java.util.NoSuchElementException;

/**
 *
 *  Fibonacci Iterator till upper limit
 */
public class FibonacciIteratorTillUpperLimit<T extends Number  & Comparable<T>> extends AbstractFibonacciIterator<T>{
    private int number;
    private T upperLimit;

    public FibonacciIteratorTillUpperLimit(T start, T end, T upperLimit) {
        super(start, end);
        if(upperLimit==null){
            throw new IllegalArgumentException("invalid uppper limit");
        }
        if(upperLimit.compareTo(start)<0){
            throw new IllegalArgumentException("Invalid upper limit");
        }
        this.upperLimit = upperLimit;
        number=1;
        setAdvance();
    }

    @Override
    public boolean hasNext() {
        return nextNumber.compareTo(upperLimit)<=0;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("No More elements");
        }
        T prevNextNumber = nextNumber;
        setAdvance();
        return prevNextNumber;
    }


    private void setAdvance(){
        if(number==1){
            nextNumber = start;
            number++;
        }else if (number==2){
            nextNumber=end;
            number++;
        }else{
            Number sum = add();
            start=end;
            end=(T)sum;
            nextNumber=end;
        }
    }


}
