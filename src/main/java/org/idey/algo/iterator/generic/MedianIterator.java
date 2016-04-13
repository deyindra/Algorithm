package org.idey.algo.iterator.generic;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MedianIterator<T extends Comparable<T>> implements Iterator<T>{
    private int size;
    private T[] array;
    private T median;
    private int currentIndex;
    private PriorityQueue<T> minHeap = new PriorityQueue<>();
    private PriorityQueue<T> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianIterator(T[] array, int size) {
        if(array==null || array.length==0){
            throw new IllegalArgumentException("Invalid Array");
        }

        if(size==0 || size>array.length){
            throw new IllegalArgumentException("Invalid size");
        }
        this.array = array;
        this.size = size;

        maxHeap.offer(array[0]);
        currentIndex=1;
        for(;currentIndex<size;currentIndex++){
            add(array[currentIndex]);
        }
        currentIndex--;
        median = maxHeap.peek();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Method not supproted");
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T prevMedian = median;
        currentIndex++;
        if(currentIndex<=array.length-1){
            add(array[currentIndex]);
            remove(array[currentIndex-size]);
            median = maxHeap.peek();
        }
        return prevMedian;
    }

    @Override
    public boolean hasNext() {
        return currentIndex<=array.length-1;
    }


    public void add(T val){
        T prevMedian = maxHeap.peek();
        if(val.compareTo(prevMedian)>0){
            minHeap.offer(val);
        }else{
            maxHeap.offer(val);
        }
        balance();
    }

    public void remove(T val){
        T prevMedian = maxHeap.peek();
        if(val.compareTo(prevMedian)>0){
            minHeap.remove(val);
        }else{
            maxHeap.remove(val);
        }
        balance();
    }

    public void balance(){
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }else if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }


    public static void main(String[] args) {
        MedianIterator<Integer> medianIterator = new MedianIterator<>(new Integer[]{2,1,3,-1},3);
        while (medianIterator.hasNext()){
            System.out.println(medianIterator.next());
        }
    }


}
