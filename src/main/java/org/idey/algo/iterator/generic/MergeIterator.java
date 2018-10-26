package org.idey.algo.iterator.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * @author indranildey
 * an Iterator class which does the K way mergeing between sorted object
 * @param <T>
 */
public class MergeIterator<T extends Comparable<T>> implements Iterator<T>, Iterable<T> {
    private Iterator<T>[] arrayIterator;
    private PriorityQueue<Node<T>> priorityQueue;

    public MergeIterator(Iterator<T>[] arrayIterator) {
        priorityQueue = new PriorityQueue<>();
        if(arrayIterator!=null && arrayIterator.length>0){
            this.arrayIterator=arrayIterator;
            int index=0;
            for(Iterator<T> it: arrayIterator){
                if(it!=null && it.hasNext()){
                    Node<T> object = new Node<>(index,it.next());
                    priorityQueue.offer(object);
                }
                index++;
            }

        }
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more element found");
        }
        Node<T> object = priorityQueue.poll();
        Iterator<T> it = arrayIterator[object.index];
        if(it!=null && it.hasNext()){
            Node<T> newObject = new Node<>(object.index,it.next());
            priorityQueue.offer(newObject);
        }
        return object.object;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove Operation is not supported");
    }


    private static class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
        private T object;
        private int index;

        public Node(int index, T object) {
            this.index = index;
            this.object = object;
        }

        @Override
        public int compareTo(Node<T> o) {
            if(this==o){
                return 0;
            }else if(o==null){
                return 1;
            }else{
                if(this.object==null){
                    return -1;
                }else {
                    if (o.object == null){
                        return 1;
                    }else{
                        return this.object.compareTo(o.object);
                    }
                }
            }
        }
    }
}
