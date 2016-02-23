package org.idey.algo.iterator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@RunWith(Parameterized.class)
public class SuccessFilterIterator extends AbstractFilterIteratorTest {
    private Iterator<Integer> expectedOutput;

    public SuccessFilterIterator(Validate<Integer> validate,
                                 Integer[] expectedOutput, Integer... values) {
        super(validate, values);
        this.expectedOutput = Arrays.asList(expectedOutput).iterator();
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {(Validate<Integer>) object -> object%2==0,new Integer[]{2,4,6},new Integer[]{2,3,4,5,6}},
                {(Validate<Integer>) object -> object!=null,new Integer[]{2,4,6},new Integer[]{2,null,4,null,6}}
        });
    }


    @Test
    public void testFilter(){
        FilterIterator<Integer> filterIterator = new FilterIterator<>(iterator,validate);
        while (filterIterator.hasNext() && expectedOutput.hasNext()){
            Assert.assertEquals(filterIterator.next(),expectedOutput.next());
        }

    }
}
