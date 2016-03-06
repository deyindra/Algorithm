package org.idey.algo.iterator.tree;

import org.idey.algo.iterator.generic.AbstractMergeIteratorTest;
import org.idey.algo.iterator.generic.MergeIterator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@RunWith(Parameterized.class)
public class SuccessTreeTraversalIteratorTest extends AbstractTreeTraversalIteratorTest{

    public SuccessTreeTraversalIteratorTest(Integer[] expectedOutput,
                                            TraversalType type) {
        super(expectedOutput, type);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1,2,4,5,3},TraversalType.PREORDER},
                {new Integer[]{4,2,5,1,3},TraversalType.INORDER},
                {new Integer[]{4,5,2,3,1},TraversalType.POSTORDER},
                {new Integer[]{1,2,3,4,5},TraversalType.LEVELORDER},
                {new Integer[]{1,2,3},TraversalType.ADVANCELEVELORDER_TILL_LEVEL_1},
                {new Integer[]{1,2,3,4,5},TraversalType.ADVANCELEVELORDER_TILL_LEVEL_10},
        });
    }


    @Test
    public void testTraversal(){
        AbstractTreeIterator<Integer> iterator = type.getIterator(tree);
        for(Integer val:expectedOutput){
            Assert.assertEquals(val, iterator.next());
        }
    }


}
