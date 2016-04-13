package org.idey.algo.oops.pool.object;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentObjectPool<T> implements ObjectPool<T> {
    private ReentrantReadWriteLock.ReadLock readLock;
    private ReentrantReadWriteLock.WriteLock writeLock;
    private Set<PooledObject<T>> unlock;
    private Set<PooledObject<T>> lock;
    private PoolObjectFactory<T> poolObkectFactory;

    public ConcurrentObjectPool() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        unlock = new LinkedHashSet<>();
        this.lock = new LinkedHashSet<>();
    }

    @Override
    public void checkIn(PooledObject<T> object) {
        writeLock.lock();
        try{
            if(lock.contains(object)){
                lock.remove(object);
                object.updateTs();
                unlock.add(object);
            }else{
                throw new IllegalArgumentException("Object is created outside of Pool");
            }
        }finally {
            writeLock.unlock();
        }
    }

    @Override
    public PooledObject<T> checkout() {
        writeLock.lock();
        PooledObject<T> pooledObject=null;
        try{
            int size= unlock.size();
            if(size>0){
                Iterator<PooledObject<T>> iterator = unlock.iterator();
                pooledObject = iterator.next();
                unlock.remove(pooledObject);
                if(System.currentTimeMillis()-pooledObject.getTimeStamp()>30){
                    pooledObject.close();
                    pooledObject=null;
                }else{
                    if(!pooledObject.isValid()){
                        pooledObject.close();
                        pooledObject=null;
                    }
                }
            }
            if(pooledObject==null){
                pooledObject = poolObkectFactory.create();
            }
            lock.add(pooledObject);
            return pooledObject;
        }finally {
            writeLock.unlock();
        }
    }

    public int getNumberOfAvailableObject(){
        readLock.lock();
        try{
            return unlock.size();
        }finally {
            readLock.unlock();
        }
    }
}
