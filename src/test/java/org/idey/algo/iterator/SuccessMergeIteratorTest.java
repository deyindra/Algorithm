package org.idey.algo.iterator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@RunWith(Parameterized.class)
public class SuccessMergeIteratorTest extends AbstractMergeIteratorTest{
    private Iterator<Integer> expectedOutput;

    public SuccessMergeIteratorTest(Iterator<Integer>[] iterators, Iterator<Integer> expectedOutput) {
        super(iterators);
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {(Iterator<Integer>[])new Iterator[]{Arrays.asList(null,7,15).iterator(), null, Arrays.asList(1,2,9).iterator()}, Arrays.asList(null,1,2,7,9,15).iterator()},
        });
    }

    @Test
    public void testMergeIterator(){
        Iterator<Integer> mergeIterator = new MergeIterator<>(iterators);
        while (expectedOutput.hasNext()){
            Assert.assertEquals(expectedOutput.next(),mergeIterator.next());
        }
    }

}
