package org.idey.algo.iterator.graph;

import org.idey.algo.ds.graph.Graph;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author indranildey
 * Breadth First Search Iterator for Graph
 */
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

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(4,1);
        graph.addEdge(5,null);


        BFSGraphTraversalIterator<Integer> bfs = new BFSGraphTraversalIterator<>(1,graph);
        while (bfs.hasNext()){
            System.out.println(bfs.next());
        }
    }
}
