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

    public static <T> int connectedComponents(Graph<T> g){
        Set<T> visited = new HashSet<>();
        int count=0;
        for(T node:g.getAllVertices()){
            if(!visited.contains(node)){
                connectedComponents(node,g,visited);
                count++;
            }
        }
        return count;
    }

    private static <T> void connectedComponents(T node, Graph<T> g, Set<T> visited) {
        visited.add(node);
        for(T child:g.getNeighbors(node)){
            if(!visited.contains(child)){
                connectedComponents(child,g,visited);
            }
        }
    }


    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);
        g.addEdge(7,9);
//        Stack<Integer> s = topoLogicalSort(g);
//        while (!s.isEmpty()){
//            System.out.println(s.pop());
//        }

        System.out.print(connectedComponents(g));
    }
}
