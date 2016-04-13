package org.idey.algo.iterator.generic;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractFibonacciIterator<T extends Number  & Comparable<T>> implements Iterator<T> {
    protected T start;
    protected T end;
    protected T nextNumber;


    public AbstractFibonacciIterator(T start, T end) {
        if(start==null || end==null || (start).compareTo(end)>0){
            throw new IllegalArgumentException("Invalid Input");
        }
        this.start = start;
        this.end = end;
    }

    protected Number add(){
        if(start instanceof Byte && end instanceof  Byte){
            return (start.byteValue()+end.byteValue());
        }else if(start instanceof Short && end instanceof  Short){
            return start.shortValue()+end.shortValue();
        }else if(start instanceof Integer && end instanceof  Integer){
            return start.intValue()+end.intValue();
        }else if(start instanceof Float && end instanceof  Float){
            return start.floatValue()+end.floatValue();
        }else if(start instanceof Double && end instanceof  Double){
            return start.doubleValue()+end.doubleValue();
        }else if(start instanceof Long && end instanceof  Long){
            return start.longValue()+end.longValue();
        }else if(start instanceof BigDecimal && end instanceof BigDecimal){
            return ((BigDecimal) start).add((BigDecimal)end);
        }else{
            throw new UnsupportedOperationException("Invalid type.... not supported yet");
        }
    }





}
