package org.idey.algo.ds.graph;

import java.util.HashSet;
import java.util.Set;

public class GraphUtil {

    public static <T> boolean detectCycle(Graph<T> g){
        boolean isCycle;
        if(g==null){
            throw new IllegalArgumentException("Invalid graph....");
        }else{
            if(!g.isDirected()){
                isCycle = detectCycleUndirected(g);
            }else{
                isCycle = detectCycleDirected(g);
            }
        }
        return isCycle;
    }

    private static <T> boolean detectCycleUndirected(Graph<T> g){
        Set<T> visited = new HashSet<>();
        for(T vertex : g.getAllVertices()){
            if(visited.contains(vertex)){
                continue;
            }
            boolean flag = hasCycleDFSUtil(g, vertex, visited, null);
            if(flag){
                return true;
            }
        }
        return false;
    }

    private static <T> boolean hasCycleDFSUtil(Graph<T> g, T vertext, Set<T> visited, T parent){
        visited.add(vertext);
        Iterable<T> adjacents = g.getNeighbors(vertext);
        for(T adj:adjacents){
            if(adj.equals(parent)){
                continue;
            }
            if(visited.contains(adj)){
                return true;
            }
            boolean flag = hasCycleDFSUtil(g,adj,visited,vertext);
            if(flag){
                return true;
            }

        }
        return false;
    }

    private static <T> boolean detectCycleDirected(Graph<T> g){
        Set<T> whiteSet = new HashSet<>();
        Set<T> graySet = new HashSet<>();
        Set<T> blackSet = new HashSet<>();

        for (T vertex : g.getAllVertices()) {
            whiteSet.add(vertex);
        }

        while (whiteSet.size() > 0) {
            T current = whiteSet.iterator().next();
            if(dfs(current, whiteSet, graySet, blackSet,g)) {
                return true;
            }
        }
        return false;
    }

    private static <T> boolean dfs(T current, Set<T> whiteSet,
                        Set<T> graySet, Set<T> blackSet, Graph<T> g) {
        //move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
        for(T neighbor : g.getNeighbors(current)) {
            //if in black set means already explored so continue.
            if (blackSet.contains(neighbor)) {
                continue;
            }
            //if in gray set then cycle found.
            if (graySet.contains(neighbor)) {
                return true;
            }
            if(dfs(neighbor, whiteSet, graySet, blackSet,g)) {
                return true;
            }
        }
        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
    }

    private static <T> void moveVertex(T vertex, Set<T> sourceSet,
                            Set<T> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

}
