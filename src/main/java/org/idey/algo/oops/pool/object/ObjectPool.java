package org.idey.algo.oops.pool.object;

public interface ObjectPool<T> {
    PooledObject<T> checkout();
    void checkIn(PooledObject<T> object);
}
