package org.idey.algo.iterator.graph;

import org.idey.algo.ds.graph.Graph;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BFSGraphTraversalIterator<T> extends AbstractGraphTraversalIterator<T> {
    private Queue<T> queue;

    public BFSGraphTraversalIterator(T start, Graph<T> graph) {
        super(start, graph);
        this.queue = new LinkedList<>();
        this.visited.add(start);
        queue.offer(start);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more elements");
        }
        T object = queue.poll();
        for(T neighbour: graph.getNeighbors(object)){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                queue.offer(neighbour);
            }
        }
        return object;
    }

}
