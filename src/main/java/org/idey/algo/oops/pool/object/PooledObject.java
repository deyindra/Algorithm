package org.idey.algo.oops.pool.object;

public abstract class PooledObject<T> {
    private long timeStamp;
    private T object;

    protected PooledObject(T object) {
        this.object = object;
        timeStamp = System.currentTimeMillis();
    }

    public T getObject() {
        return object;
    }

    protected void updateTs(){
        timeStamp = System.currentTimeMillis();
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PooledObject<?> that = (PooledObject<?>) o;

        return !(object != null ? !object.equals(that.object) : that.object != null);

    }

    @Override
    public int hashCode() {
        return object != null ? object.hashCode() : 0;
    }

    protected abstract boolean isValid();
    protected abstract void close();

}
