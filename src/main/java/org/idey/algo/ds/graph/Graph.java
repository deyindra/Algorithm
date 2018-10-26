package org.idey.algo.ds.graph;

import java.util.*;

@SuppressWarnings("ALL")
public class Graph<T> {
    private Map<T, Set<T>> map;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        map = new HashMap<>();
        this.isDirected = isDirected;
    }

    public Graph() {
        this(false);
    }

    public Graph addEdge(T src, T destination){
        if(src==null){
            throw new IllegalArgumentException("Invalid Source or Destination vertext");
        }else if(src==destination || src.equals(destination)){
            throw new IllegalArgumentException("Source and Destination can not be same");
        }else{
            Set<T> desitinations = map.get(src);
            if(desitinations==null){
                desitinations = new LinkedHashSet<>();
            }
            if(destination!=null){
                desitinations.add(destination);
                Set<T> destinationsOfDestination = map.get(destination);
                if(destinationsOfDestination==null){
                    destinationsOfDestination = new LinkedHashSet<>();
                }
                if(!isDirected){
                    destinationsOfDestination.add(src);
                }
                map.put(destination,destinationsOfDestination);
            }
            map.put(src,desitinations);
        }
        return this;
    }

    public Iterable<T> getNeighbors(T vertex) {
        Set<T> neighbors = this.map.get(vertex);
        if (neighbors == null || neighbors.isEmpty()) {
            return Collections.emptySet();
        } else {
            return Collections.unmodifiableSet(neighbors);
        }
    }

    public Iterable<T> getAllVertices(){
        if(!map.isEmpty()){
            return Collections.unmodifiableSet(map.keySet());
        }else{
            return Collections.emptySet();
        }
    }

    public boolean isVertexExist(T vertex){
        return map.containsKey(vertex);
    }

    public boolean isGraphEmpty(){
        return map.isEmpty();
    }

    public boolean isDirected() {
        return isDirected;
    }
}
