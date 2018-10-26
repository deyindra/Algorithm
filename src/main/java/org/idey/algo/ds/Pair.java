package org.idey.algo.ds;

import java.util.Map;

public interface Pair<K,V> extends Map.Entry<K,V> {
    @Override
    default  V setValue(V value) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    static <K,V> Pair<K,V> of(K key, V value) {
        return new PairImpl<>(key,value);
    }

    class PairImpl<K,V> implements Pair<K,V>{
        private K key;
        private V value;

        private PairImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "PairImpl{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
