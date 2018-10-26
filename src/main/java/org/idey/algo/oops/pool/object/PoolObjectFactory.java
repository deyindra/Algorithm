package org.idey.algo.oops.pool.object;

public abstract class PoolObjectFactory<T> {
    abstract PooledObject<T> create();
}
