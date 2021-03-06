package org.idey.algo.iterator.generic;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeNumberIterator implements Iterator<Integer>{
    private int upperLimit;
    private BitSet bitSet;
    private int nextNumber;

    public PrimeNumberIterator(int upperLimit) {
        if(upperLimit<2){
            throw new IllegalArgumentException("Invalid upper limit");
        }
        this.upperLimit = upperLimit+1;
        bitSet = new BitSet(this.upperLimit);
        bitSet.set(0,false);
        bitSet.set(1, false);
        bitSet.set(2, this.upperLimit, true);
        nextNumber=2;
        setAdvance();
    }

    private void setAdvance() {
        while (nextNumber<upperLimit){
            boolean isPrime = bitSet.get(nextNumber);
            if(isPrime){
                for(int j=2;j*nextNumber<upperLimit;j++){
                    bitSet.set(j*nextNumber,false);
                }
                break;
            }else{
                nextNumber++;
            }

        }
    }

    @Override
    public boolean hasNext() {
        return nextNumber<upperLimit;
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        int prevNextNumber = nextNumber;
        nextNumber++;
        setAdvance();
        return prevNextNumber;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new PrimeNumberIterator(1000);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}
