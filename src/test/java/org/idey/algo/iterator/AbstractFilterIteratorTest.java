package org.idey.algo.iterator;

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
