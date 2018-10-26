package org.idey.algo.iterator.graph;

import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailedGraphTraversalIteratorTest extends AbstractGraphTraversalIteratorTest{
    protected boolean isPassGraphAsNull;
    public FailedGraphTraversalIteratorTest(Integer start, Integer[] expectedOutput,
                                            TraversalType type,
                                            boolean isDirected,boolean isPaaGraphAsNull) {
        super(start, expectedOutput, type, isDirected);
        this.isPassGraphAsNull=isPaaGraphAsNull;
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, new Integer[]{1,2,3,4}, TraversalType.BFS, true,true},
                {6, new Integer[]{1,2,3,4}, TraversalType.BFS, false,false},
                {1, new Integer[]{1,2,4,3}, TraversalType.DFS, true,true},
                {6, new Integer[]{1,2,4,3}, TraversalType.DFS, false,false},
        });
    }


    @Test
    public void testTraversal(){
        expectedException.expect(IllegalArgumentException.class);
        if(isPassGraphAsNull) {
            AbstractGraphTraversalIterator<Integer> iterator = type.getIterator(null, start);
        }else{
            AbstractGraphTraversalIterator<Integer> iterator = type.getIterator(g, start);
        }
    }


}
