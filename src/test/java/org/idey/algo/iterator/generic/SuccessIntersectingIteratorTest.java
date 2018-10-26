package org.idey.algo.iterator.generic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@RunWith(Parameterized.class)
public class SuccessIntersectingIteratorTest extends AbstractIntersectingIteratorTest{
    private Integer[] expectedResults;
    protected boolean expectedHasNext;

    public SuccessIntersectingIteratorTest(Iterator<Integer>[] iterators, boolean expectedHasNext, Integer[] expectedResults) {
        super(iterators);
        this.expectedHasNext = expectedHasNext;
        this.expectedResults = expectedResults;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Iterator[]{Arrays.asList(5,7).iterator(),Arrays.asList(1,2,3,5).iterator(),Arrays.asList(3,5).iterator()}, true, new Integer[]{5}},
                {new Iterator[]{Arrays.asList(5,5,7).iterator(),Arrays.asList(1,2,3,5,5).iterator(),Arrays.asList(3,5,5).iterator()}, true, new Integer[]{5,5}},
                {new Iterator[]{Arrays.asList(1,2,3,5,5).iterator(),Arrays.asList(3,5,5).iterator(),Arrays.asList().iterator()},false, null},
                {new Iterator[]{Arrays.asList(1,7,9).iterator(),Arrays.asList(5,7).iterator(),Arrays.asList(4,5,7).iterator()},true, new Integer[]{7}},
                {new Iterator[]{Arrays.asList(1,7,9).iterator(),Arrays.asList(5).iterator(),Arrays.asList(4,5,7).iterator()},false, new Integer[]{}},


        });
    }


    @Test
    public void testIntersection(){
        IntersectionIterator<Integer> iterator = new IntersectionIterator<>(iterators);
        Assert.assertEquals(expectedHasNext,iterator.hasNext());
        int count=0;
        while (iterator.hasNext()){
            Assert.assertEquals(iterator.next(),expectedResults[count++]);
        }
    }

}

