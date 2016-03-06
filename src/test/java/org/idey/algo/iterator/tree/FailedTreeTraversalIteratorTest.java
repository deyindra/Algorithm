package org.idey.algo.iterator.tree;


import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailedTreeTraversalIteratorTest extends AbstractTreeTraversalIteratorTest{
    public FailedTreeTraversalIteratorTest(Integer[] expectedOutput, TraversalType type) {
        super(expectedOutput, type);
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 4, 5, 3}, TraversalType.PREORDER},
                {new Integer[]{4, 2, 5, 1, 3}, TraversalType.INORDER},
                {new Integer[]{4, 5, 2, 3, 1}, TraversalType.POSTORDER},
                {new Integer[]{1, 2, 3, 4, 5}, TraversalType.LEVELORDER},
                {new Integer[]{1, 2, 3}, TraversalType.ADVANCELEVELORDER_TILL_LEVEL_1},
                {new Integer[]{1, 2, 3, 4, 5}, TraversalType.ADVANCELEVELORDER_TILL_LEVEL_10},
        });
    }

    @Test
    public void testTraversal(){
        expectedException.expect(IllegalArgumentException.class);
        AbstractTreeIterator<Integer> iterator = type.getIterator(tree);
    }

}
