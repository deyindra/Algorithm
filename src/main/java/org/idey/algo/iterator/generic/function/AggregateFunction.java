package org.idey.algo.iterator.generic.function;


import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class AggregateFunction<T extends Comparable<T>> implements Function<Map<Long, List<T>>, T> {
    @Override
    public <V> Function<V, T> compose(Function<? super V, ? extends Map<Long, List<T>>> before) {
        throw new UnsupportedOperationException("Operation is not supported");
    }

    @Override
    public <V> Function<Map<Long, List<T>>, V> andThen(Function<? super T, ? extends V> after) {
        throw new UnsupportedOperationException("Operation is not supported");
    }
}
