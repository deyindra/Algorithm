package org.idey.algo.iterator;

import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailedFilterIteratorTest extends AbstractFilterIteratorTest{
    public FailedFilterIteratorTest(Validate<Integer> validate, Integer... values) {
        super(validate, values);
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, new Integer[]{2,3,4,5,6}},
                {(Validate<Integer>) object -> object != null, null}
        });
    }


    @Test
    public void failedTest(){
        expectedException.expect(Exception.class);
        FilterIterator<Integer> filterIterator = new FilterIterator<>(iterator,validate);
        if(validate!=null){
            filterIterator.next();
        }
    }
}
