package org.idey.algo.iterator.generic;

import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailedIntegerFibonacciIteratorTillNthNumberTest extends AbstractFibonacciIteratorTest<Integer>{
    private int upperLimit;

    public FailedIntegerFibonacciIteratorTillNthNumberTest(Integer start, Integer end, int upperLimit) {
        super(start, end);
        this.upperLimit = upperLimit;
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1,-1,1},
                {1,2,-1},
                {1,null,1},
                {null,1,1},
        });
    }


    @Test
    public void test(){
        expectedException.expect(Exception.class);
        AbstractFibonacciIterator<Integer> iterator = new FibonacciIteratorTillNthNumber<>(start,end,upperLimit);
    }
}
