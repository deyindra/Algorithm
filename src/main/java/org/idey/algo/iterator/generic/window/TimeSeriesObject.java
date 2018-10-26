package org.idey.algo.iterator.generic.window;

public class TimeSeriesObject<T extends Comparable<T>> implements Comparable<TimeSeriesObject<T>>{
    private T object;
    private Long currentTs;

    public TimeSeriesObject(T object) {
        this.object = object;
        currentTs = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSeriesObject<?> that = (TimeSeriesObject<?>) o;

        return object != null ? object.equals(that.object) : that.object == null
                && (currentTs != null ? currentTs.equals(that.currentTs) : that.currentTs == null);
    }

    @Override
    public int hashCode() {
        int result = object != null ? object.hashCode() : 0;
        result = 31 * result + (currentTs != null ? currentTs.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(TimeSeriesObject<T> o) {
        if(o==null){
            return 1;
        }else if(this==o){
            return 0;
        }else{
            if(this.currentTs==null){
                return -1;
            }else{
                int returnValue = this.currentTs.compareTo(o.currentTs);
                if(returnValue==0){
                    if(this.object==null){
                        return -1;
                    }else{
                        return this.object.compareTo(o.object);
                    }
                }else{
                    return returnValue;
                }
            }
        }
    }
}
