package org.idey.algo.iterator;

import java.util.Iterator;

public abstract class AbstractMergeIteratorTest {
    protected Iterator<Integer>[] iterators;

    protected AbstractMergeIteratorTest(Iterator<Integer>[] iterators) {
        this.iterators = iterators;
    }


}
