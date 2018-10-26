package org.idey.algo.iterator.graph;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SuccessGraphTraversalIteratorTest extends AbstractGraphTraversalIteratorTest{

    public SuccessGraphTraversalIteratorTest(Integer start, Integer[] expectedOutput,
                                             TraversalType type,
                                             boolean isDirected) {
        super(start, expectedOutput, type, isDirected);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, new Integer[]{1,2,3,4}, TraversalType.BFS, true},
                {1, new Integer[]{1,2,3,4}, TraversalType.BFS, false},
                {1, new Integer[]{1,2,4,3}, TraversalType.DFS, true},
                {1, new Integer[]{1,2,4,3}, TraversalType.DFS, false},
        });
    }


    @Test
    public void testTraversal(){
        AbstractGraphTraversalIterator<Integer> iterator = type.getIterator(g,start);
        for(Integer val:expectedOutput){
            Assert.assertEquals(val, iterator.next());
        }
    }


}
