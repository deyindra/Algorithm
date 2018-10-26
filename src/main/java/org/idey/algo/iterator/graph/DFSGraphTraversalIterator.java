package org.idey.algo.iterator.graph;

import org.idey.algo.ds.graph.Graph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
/**
 * @author indranildey
 * Depth First Search Iterator for Graph
 */
public class DFSGraphTraversalIterator<T> extends AbstractGraphTraversalIterator<T>{
    private Stack<Iterator<T>> neighbours;
    private T next;

    public DFSGraphTraversalIterator(T start, Graph<T> graph) {
        super(start, graph);
        neighbours = new Stack<>();
        this.next=start;
        this.neighbours.push(graph.getNeighbors(this.next).iterator());
    }

    @Override
    public boolean hasNext() {
        return this.next!=null;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("No More elements");
        }
        try{
            visited.add(this.next);
            return next;
        }finally {
            setAdvance();
        }
    }

    private void setAdvance(){
        Iterator<T> neighbour = neighbours.peek();
        do{
            while (!neighbour.hasNext()){
                neighbours.pop();
                if(neighbours.isEmpty()){
                    this.next=null;
                    return;
                }
                neighbour = neighbours.peek();
            }
            this.next = neighbour.next();
        }while (this.visited.contains(this.next));
        this.neighbours.push(graph.getNeighbors(this.next).iterator());
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(4,1);
        graph.addEdge(5,null);


        DFSGraphTraversalIterator<Integer> dfs = new DFSGraphTraversalIterator<>(1,graph);
        while (dfs.hasNext()){
            System.out.println(dfs.next());
        }
    }
}
