package org.idey.algo.iterator.generic;

import org.idey.algo.iterator.generic.Validate;

import java.util.Arrays;
import java.util.Iterator;

public abstract class AbstractFilterIteratorTest {
    protected Iterator<Integer> iterator;
    protected Validate<Integer> validate;

    public AbstractFilterIteratorTest(Validate<Integer> validate,
                                      Integer... values) {
        this.validate = validate;
        if(values!=null && values.length>0){
            iterator = Arrays.asList(values).iterator();
        }
    }
}
