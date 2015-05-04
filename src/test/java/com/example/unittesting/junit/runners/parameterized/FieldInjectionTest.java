package com.example.unittesting.junit.runners.parameterized;

import com.example.unittesting.junit.helpers.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FieldInjectionTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {2, 3}, {3, 6}, {4, 10}, {5, 15}, {10, 55}, {20, 210}
        });
    }

    @Parameter(value = 0)
    public int input;

    @Parameter(value = 1)
    public int expected;

    @Test
    public void testSumUpTo() {
        System.out.println("Testing with values: (" + input + "," + expected + ")");
        Assert.assertEquals("Wrong result", expected, Calculator.sumUpTo(input));
    }

}
