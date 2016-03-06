package org.idey.algo.iterator.graph;

import org.idey.algo.ds.graph.Graph;
import org.junit.Before;

public abstract class AbstractGraphTraversalIteratorTest {
    protected Graph<Integer> g;
    protected Integer start;
    protected Integer[] expectedOutput;
    protected TraversalType type;
    protected boolean isDirected;

    public AbstractGraphTraversalIteratorTest(Integer start,
                                              Integer[] expectedOutput,
                                              TraversalType type, boolean isDirected) {
        this.start = start;
        this.expectedOutput = expectedOutput;
        this.type = type;
        this.isDirected = isDirected;
    }

    @Before
    public void init(){
        g=new Graph<>(this.isDirected);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
    }

    protected enum TraversalType{
        BFS{
            @Override
            protected AbstractGraphTraversalIterator<Integer> getIterator(Graph<Integer> g, Integer start) {
                return new BFSGraphTraversalIterator<>(start,g);
            }
        },
        DFS{
            @Override
            protected AbstractGraphTraversalIterator<Integer> getIterator(Graph<Integer> g, Integer start) {
                return new DFSGraphTraversalIterator<>(start,g);
            }
        };
        protected abstract AbstractGraphTraversalIterator<Integer> getIterator(Graph<Integer> g, Integer start);
    }
}
