package org.idey.algo.iterator.generic;

import org.idey.algo.rule.ExceptionLoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@RunWith(Parameterized.class)
public class FailedMergeIteratorTest extends AbstractMergeIteratorTest{

    public FailedMergeIteratorTest(Iterator<Integer>[] iterators) {
        super(iterators);
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null},
                {(Iterator<Integer>[])new Iterator[]{}}
        });
    }

    @Test
    public void testMergeIterator(){
        expectedException.expect(Exception.class);
        Iterator<Integer> mergeIterator = new MergeIterator<>(iterators);
        mergeIterator.next();
    }

}
