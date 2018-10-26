package org.idey.algo.iterator.generic.function;

import java.util.List;
import java.util.Map;

public class SumFunction<T extends Number & Comparable<T>> extends AggregateFunction<T> {
    private final int windowSize;
    private Number lastSum;
    private Long headIndex;

    public SumFunction(int windowSize, long headIndex) {
        if(windowSize<=0){
            throw new IllegalArgumentException("Invalid window size");
        }
        this.windowSize = windowSize;
        this.headIndex=headIndex;
    }

    @Override
    public T apply(Map<Long, List<T>> longListMap) {
        return null;
    }
}
