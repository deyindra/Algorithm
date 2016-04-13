package org.idey.algo.iterator.generic;


import java.util.NoSuchElementException;

/**
 * Fibonacci Iterator till Nth number
 *
 */
public class FibonacciIteratorTillNthNumber<T extends Number  & Comparable<T>> extends AbstractFibonacciIterator<T>{
    private int number;
    private int upperLimit;

    public FibonacciIteratorTillNthNumber(T start, T end, int upperLimit) {
        super(start, end);
        if(upperLimit<=0){
            throw new IllegalArgumentException("Invalid Upper Limit");
        }
        number=1;
        this.upperLimit = upperLimit;
    }

    @Override
    public boolean hasNext() {
        return number<=upperLimit;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("No More elements");
        }
        setAdvance();
        return nextNumber;
    }


    private void setAdvance(){
        if(number==1){
            nextNumber = start;
        }else if (number==2){
            nextNumber=end;
        }else{
            Number sum = add();
            start=end;
            end=(T)sum;
            nextNumber=end;
        }
        number++;
    }


}
