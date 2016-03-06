package org.idey.algo.iterator.graph;

import org.idey.algo.ds.graph.Graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractGraphTraversalIterator<T> implements Iterator<T>{
    protected Graph<T> graph;
    protected Set<T> visited;

    protected AbstractGraphTraversalIterator(T start, Graph<T> graph){
        if(graph==null){
            throw new IllegalArgumentException("Invalid graph...");
        }
        if(!graph.isVertexExist(start)){
            throw new IllegalArgumentException("Invalid Start Node");
        }
        this.graph=graph;
        visited = new HashSet<>();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Method not supported");
    }
}
