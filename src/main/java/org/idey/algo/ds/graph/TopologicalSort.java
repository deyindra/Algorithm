package org.idey.algo.ds.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
    private static <T> void topoLogicalSort(T node, Set<T> visited, Stack<T> stack, Graph<T> g){
        visited.add(node);

        Iterable<T> nodes = g.getNeighbors(node);
        for(T n:nodes){
            if(!visited.contains(n)){
                topoLogicalSort(n,visited,stack,g);
            }
        }
        stack.push(node);
    }

    public static <T> Stack<T> topoLogicalSort(Graph<T> g){
        Stack<T> s = new Stack<>();
        Set<T> visited = new HashSet<>();

        for(T node: g.getAllVertices()){
            if(!visited.contains(node)){
                topoLogicalSort(node,visited,s,g);
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>(true);
        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);
        Stack<Integer> s = topoLogicalSort(g);
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
