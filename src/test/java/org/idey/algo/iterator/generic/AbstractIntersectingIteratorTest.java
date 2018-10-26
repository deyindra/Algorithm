package org.idey.algo.iterator.generic;

import java.util.Iterator;

public abstract class AbstractIntersectingIteratorTest {
    protected Iterator<Integer>[] iterators;

    protected AbstractIntersectingIteratorTest(Iterator<Integer>[] iterators) {
        this.iterators = iterators;
    }
}
