package org.idey.algo.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author indranildey
 * FilterIterator which filter the only return the element for which pass the {@link Validate#validate(Object)}
 */
public class FilterIterator<T> implements Iterator<T>, Iterable<T>{
    private T currentObject;
    private Iterator<T> it;
    private boolean hasNext;
    private Validate<T> validate;

    public FilterIterator(Iterator<T> it, Validate<T> validate) {
        if(validate==null){
            throw new IllegalArgumentException("Validate object can not be null");
        }
        this.it = it;
        this.validate = validate;
        setNextObject();
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public T next() {
        if(!hasNext){
            throw new NoSuchElementException("No Such element exists");
        }
        T prevObject = currentObject;
        setNextObject();
        return prevObject;
    }

    private void setNextObject(){
        hasNext=false;
        if(it!=null){
            while (it.hasNext()){
                T object = it.next();
                if(validate.validate(object)){
                    currentObject=object;
                    hasNext=true;
                    break;
                }
            }
        }
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException("Method is not supported");
    }
}
