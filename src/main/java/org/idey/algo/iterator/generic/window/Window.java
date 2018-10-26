package org.idey.algo.iterator.generic.window;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public enum Window{
    SECONDS{
        @Override
        protected long calculate(long t1, long t2) {
            long diff = t2 - t1;
            return TimeUnit.MILLISECONDS.toSeconds(diff);
        }
    },

    MINUTE{
        @Override
        protected long calculate(long t1, long t2) {
            long diff = t2 - t1;
            return TimeUnit.MILLISECONDS.toMinutes(diff);
        }
    },

    HOUR{
        @Override
        protected long calculate(long t1, long t2) {
            long diff = t2 - t1;
            return TimeUnit.MILLISECONDS.toHours(diff);
        }
    };

    public long timeDifference(final long t1, final long t2){
        if(t1>t2){
            throw new IllegalArgumentException(String.format("%d has to be greater or equal to than %d",t2, t1));
        }
        return calculate(t1, t2);
    }

    public long timeDifference(final long t){
        return timeDifference(System.currentTimeMillis(),t);
    }
    protected abstract long calculate(final long t1, final long t2);

    public static void main(String[] args) throws InterruptedException {
        Timestamp t1 = new Timestamp(System.currentTimeMillis());
        Thread.sleep(1000L);
        Timestamp t2 = new Timestamp(System.currentTimeMillis());

        System.out.println(t1);
        System.out.println(t2);

        System.out.println(Window.HOUR.timeDifference(t1.getTime(),t2.getTime()));
    }
}
