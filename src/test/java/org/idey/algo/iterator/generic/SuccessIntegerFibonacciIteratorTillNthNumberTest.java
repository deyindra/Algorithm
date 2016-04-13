package org.idey.algo.iterator.generic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SuccessIntegerFibonacciIteratorTillNthNumberTest extends AbstractFibonacciIteratorTest<Integer>{
    private int upperLimit;
    private Integer[] expectedResults;

    public SuccessIntegerFibonacciIteratorTillNthNumberTest(Integer start, Integer end, Integer[] expectedResults, int upperLimit) {
        super(start, end);
        this.expectedResults = expectedResults;
        this.upperLimit = upperLimit;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1,2,new Integer[]{1},1},
                {1,2,new Integer[]{1,2},2},
                {1,1,new Integer[]{1,1},2},
                {1,1,new Integer[]{1,1,2},3},
                {1,2,new Integer[]{1,2,3,5},4}
        });
    }


    @Test
    public void test(){
        AbstractFibonacciIterator<Integer> iterator = new FibonacciIteratorTillNthNumber<>(start,end,upperLimit);
        int count=0;
        while (iterator.hasNext()){
            Assert.assertEquals(iterator.next(),expectedResults[count++]);
        }
    }
}
